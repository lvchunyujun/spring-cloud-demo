package com.hexiaofei.sjzclient.web.security;

import com.hexiaofei.sjzclient.common.EmailSendType;
import com.hexiaofei.sjzclient.common.EmailTemplate;
import com.hexiaofei.sjzclient.common.PlatformConstant;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.UserInfoService;
import com.hexiaofei.sjzclient.service.sms.SmsEmailService;
import com.hexiaofei.sjzclient.service.sms.SmsUserinfoService;
import com.lcyj.common.bo.sms.SmsEmail;
import com.lcyj.common.bo.sms.SmsUserinfo;
import com.lcyj.common.utils.NumberUtils;
import com.lcyj.common.utils.RegExpValidator;
import com.lcyj.common.vo.ResultVo;
import com.lcyj.common.web.WebCommonConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class RegisterController {

    private static Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private SmsUserinfoService smsUserinfoService;

    @Autowired
    private SmsEmailService smsEmailService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/toRegistor")
    public String toRegistor(){

        return "/common/register";
    }


    @RequestMapping(value = "/sendCheckCode")
    @ResponseBody
    public ResultVo sendCheckCode(HttpServletRequest request, String email){
        ResultVo resultVo = new ResultVo();

        SmsUserinfo smsUserinfo = new SmsUserinfo();

        try{
            // step1:  邮箱正确性校验

            // step2:  邮箱是否已经注册

            if(checkEmail(email,resultVo)){

                HttpSession session = request.getSession();
                String checkCode = generateCheckCode(session);

                smsUserinfo.setEmail(email);
                smsUserinfo.setPlatformId(PlatformConstant.PLATFORM_NAME);

                SmsEmail smsEmail = new SmsEmail();
                smsEmail.setPlatformId(PlatformConstant.PLATFORM_ID);
                smsEmail.setServerId(PlatformConstant.SERVER_ID);
                smsEmail.setToEmail(email);
                smsEmail.setSubject(EmailSendType.REG_CODE.getDescri());
                smsEmail.setLastUpdateTime(new Date());
                smsEmail.setEmailType(EmailSendType.REG_CODE.getType());
                smsEmail.setCreateTime(new Date());
                smsEmail.setContent(String.format(EmailTemplate.REG_CHECK_CODE,checkCode));

                String result = smsEmailService.send(smsEmail);

                if(WebCommonConstant.OK.equals(result)){
                    session.setAttribute(WebCommonConstant.REGISTER_CHECK_EMAIL,email);
                }

                resultVo.setResultCode("0000");
                resultVo.setResultMsg("验证码已经发送，请查收邮件！");
            }
        }catch (Exception e){
            LOGGER.error("验证码发送失败！",e);
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("验证码发送失败，请重新尝试！");
        }


        return resultVo;
    }

    @RequestMapping(value = "/registor")
    @ResponseBody
    public ResultVo registor(HttpServletRequest request,String email,String password,String verifyCode){
        LOGGER.info("【用户注册】-->   [email="+email+"]");
        ResultVo resultVo = new ResultVo();
        String result = "fail";
        HttpSession session = request.getSession();
        String sessionVerifyCode = (String)session.getAttribute(WebCommonConstant.REGISTER_CHECK_CODE);
        String session_email = (String)session.getAttribute(WebCommonConstant.REGISTER_CHECK_EMAIL);

        if(checkEmail(email,resultVo)&&
            email.equals(session_email)&&
            verifyCode.equals(sessionVerifyCode)){
            // 1. 注册用户
            try {
                int resultId = userInfoService.register(email,password);
                if(resultId > 0){
                    resultVo.setResultCode("0000");
                    resultVo.setResultMsg("registor_ok");
                    LOGGER.info("【用户注册】注册成功    [email="+email+"]");
                }else{
                    resultVo.setResultCode("9999");
                    resultVo.setResultMsg("注册失败！");
                }
            } catch (PlatformException e) {
                LOGGER.error("注册失败发证异常！",e);
            }
            // 2. 保存客户端类型


        }else {
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("验证码无效请重新获取！");
        }
        LOGGER.info("【用户注册】<-- [email="+email+"]");
        return resultVo;
    }

    @RequestMapping(value = "/registor_ok")
    public String registorOk(){


        return "/common/register_ok";
    }
    /**
     * HttpSession缓存一个注册校验码
     * @param session
     * @return
     */
    private String generateCheckCode(HttpSession session){
        String checkCode = NumberUtils.genRandomNumberStr(4);
        session.setAttribute(WebCommonConstant.REGISTER_CHECK_CODE,checkCode);
        session.setMaxInactiveInterval(WebCommonConstant.COOKIE_CHECK_CODE_OUTTIME);
        return checkCode;
    }

    private boolean checkEmail(String email,ResultVo resultVo){
        if(StringUtils.isBlank(email)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("邮箱不能为空！");
            return false;
        }
        if(!RegExpValidator.isEmail(email)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("邮箱格式错误！");
            return false;
        }
        UserInfo userInfo = userInfoService.getUserInfoByEmail(email);
        if(userInfo != null){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("邮箱已经注册！");
            return false;
        }
        return true;
    }

    private boolean checkCheckCode(HttpSession session,String email,ResultVo resultVo){

        String sessionVerifyCode = (String)session.getAttribute(WebCommonConstant.REGISTER_CHECK_CODE);
        String session_email = (String)session.getAttribute(WebCommonConstant.REGISTER_CHECK_EMAIL);

        if(email.equals(session_email)&&StringUtils.isNotBlank(sessionVerifyCode)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("验证码还在有效，稍后再试！");
            return false;
        }
        return true;
    }


}
