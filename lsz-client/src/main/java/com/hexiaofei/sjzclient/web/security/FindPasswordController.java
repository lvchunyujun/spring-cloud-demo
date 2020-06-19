package com.hexiaofei.sjzclient.web.security;

import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.service.IUserInfoService;
import com.hexiaofei.sjzclient.service.sms.SmsEmailService;
import com.lcyj.common.utils.RegExpValidator;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 找回密码
 */
@Controller
public class FindPasswordController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FindPasswordController.class);

    private final static String FIND_PASSWD = "findPasswd";

    @Autowired
    private SmsEmailService smsEmailService;

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 1. 输入账号
     */
    @RequestMapping(value = FIND_PASSWD+"/forgetPasswd",method = RequestMethod.GET)
    public String forgetPasswd(){
        return "common/"+FIND_PASSWD+"/verify_account";
    }

    /**
     * 2. 检查email是否存在，并发送验证链接
     */
    @RequestMapping(value = FIND_PASSWD+"/verifyAccount",method = RequestMethod.POST)
    public ModelAndView verifyAccount(String email,HttpServletRequest request){

        ModelAndView mv = new ModelAndView("common/"+FIND_PASSWD+"/verify_account");
        try {
            mv.addObject("email", email);
            // step1: 检查email合法性。
            if (checkEmail(email, mv)) {
                // step2: 发送重置邮件验证码。
                int reusltId = userInfoService.sendFindPasswdVerifyEmail(email);
                if (reusltId == 0) {
                    mv.setViewName("common/" + FIND_PASSWD + "/send_checkcode_ok");
                } else if (reusltId == -1) {
                    mv.addObject("resultMsg", "邮件发送失败请重试！");
                } else if (reusltId == -2) {
                    mv.addObject("resultMsg", "邮箱不能为空！");
                }
            }
        }catch (Exception e){
            LOGGER.error("邮箱发送异常！",e);
            mv.addObject("resultMsg", "邮箱发送失败！");
        }
        return mv;
    }

    private boolean checkEmail(String email,ModelAndView mv){
        if(StringUtils.isBlank(email)){
            mv.addObject("resultMsg","邮箱不能为空！");
            return false;
        }
        if(!RegExpValidator.isEmail(email)){
            mv.addObject("resultMsg","邮箱格式错误！");
            return false;
        }

        UserInfo userInfo = userInfoService.getUserInfoByEmail(email);
        if(userInfo == null){
            mv.addObject("resultMsg","邮箱未注册！");
            return false;
        }
        return true;
    }

    /**
     * 3. 校验连接验证码
     * @param request
     * @param mailAuthenId
     * @param email
     * @param newValidCode
     * @param sign
     * @return
     */
    @RequestMapping(value = FIND_PASSWD+"/verify")
    public ModelAndView verify(HttpServletRequest request,String email,Integer mailAuthenId, String newValidCode,String sign){
        ModelAndView mv = new ModelAndView("common/"+FIND_PASSWD+"/verify_account");


        if(checkEmail(email,mv)){
            if(mailAuthenId == null){
                mv.addObject("resultMsg","认证信息无效！");
            }else if(StringUtils.isBlank(newValidCode)){
                mv.addObject("resultMsg","认证信息无效！");
            }else if(StringUtils.isBlank(sign)){
                mv.addObject("resultMsg","认证信息无效！");
            }else{

                /**
                 * 0:通过；
                 * -100: email不能为空；
                 * -110：email不存在！；
                 * -200：认证信息不存在；
                 * -210：认证信息不一致；
                 * -300：验证签名失败；
                 * -400：链接失效；
                 */
                int resultCode = userInfoService.verifyFindPasswdEmail(email,mailAuthenId,newValidCode,sign);
                if(resultCode == 0){
                    mv.addObject("email",email);
                    mv.addObject("mailAuthenId",mailAuthenId);
                    mv.addObject("newValidCode",newValidCode);
                    mv.addObject("sign",sign);
                    mv.setViewName("common/"+FIND_PASSWD+"/reset_password");
                }else  if(resultCode == -400){
                    mv.addObject("resultMsg","验证链接超时！");
                }else{
                    mv.addObject("resultMsg","验证链接失败！");
                }
            }

        }

        return mv;
    }

    /**
     * 4. 重置密码
     * @param email
     * @param password
     * @param confirmPassword
     * @param mailAuthenId
     * @param newValidCode
     * @param sign
     * @return
     */
    @RequestMapping(value = FIND_PASSWD+"/resetPasswd",method = RequestMethod.POST)
    public String resetPasswd(String email, String password, String confirmPassword,
                                    Integer mailAuthenId, String newValidCode, String sign,
                                    Model model){
        String resultMsg = "";
        if(StringUtils.isBlank(password)){
            model.addAttribute("resultMsg","密码不能为空！");
            return "forward:"+FIND_PASSWD+"/verify";
        }

        if(password.trim().length() != password.length()){
            model.addAttribute("resultMsg","密码不能有空格！");
            return "forward:"+FIND_PASSWD+"/verify";
        }
        if(password.length() < 8){
            model.addAttribute("resultMsg","密码必须大于等于8位！");
            return "forward:"+FIND_PASSWD+"/verify";
        }
        if(!password.equals(confirmPassword)){
            model.addAttribute("resultMsg2","确认密码与密码不一致！");
            return "forward:"+FIND_PASSWD+"/verify";
        }

        int resultCode = userInfoService.updatePasswdForFindPasswd( email, password,newValidCode,  mailAuthenId,sign);
        if(resultCode == 0){
            return "common/"+FIND_PASSWD+"/reset_ok";
        }else {
            resultMsg = resolveReusltCode(resultCode);
            model.addAttribute("resultMsg",resultMsg);
            return "common/"+FIND_PASSWD+"/verify_account";


        }

    }

    private String resolveReusltCode(int resultCode){
        switch (resultCode){
            case 0: return "通过";
            case -100: return "email不能为空!";
            case -110: return "email不存在！";
            case -200: return "认证信息不存在!";
            case -210: return "认证信息不一致!";
            case -300: return "验证签名失败!";
            case -400: return "链接超时失效！";
            default:return "系统错误！";
        }
    }


}
