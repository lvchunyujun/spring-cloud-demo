package com.hexiaofei.sjzclient.web.security;

import com.hexiaofei.sjzclient.common.WebSystemConsts;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.UserInfoService;
import com.hexiaofei.sjzclient.web.AbstractBaseController;
import com.lcyj.common.utils.RegExpValidator;
import com.lcyj.common.vo.ResultVo;
import com.lcyj.common.web.WebCommonConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends AbstractBaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = WebSystemConsts.TO_LOGIN_URL)
    public String toLogin(){
        return "/common/login";
    }

    /**
     *
     * @param request
     * @param userName
     * @param password
     * @param verifyCode
     * @deprecated 废弃
     * @return
     */
//    @RequestMapping(value = WebSystemConsts.LOGIN_URL,method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,String userName,String password,String verifyCode){

        ModelAndView modelAndView = new ModelAndView("/my/eventIndex/index");

        ResultVo resultVo = new ResultVo();

        try {
            HttpSession session = request.getSession();
            session.invalidate();

            if(checkUserInfo(resultVo,userName,password)&&checkVerifyCode(session,resultVo,verifyCode)){
                UserInfo login_user = userInfoService.getUserInfoForLogin(userName,password);

                if(login_user!=null){
                    session = request.getSession();
                    session.setAttribute(WebSystemConsts.COOKIE_USER,login_user);
                    session.setMaxInactiveInterval(WebCommonConstant.COOKIE_LOGIN_IN_OUTTIME);
                    modelAndView.addObject("LOGIN_MSG","0000");
                }else{
                    modelAndView.setViewName("/common/login");
                    modelAndView.addObject("LOGIN_MSG","1000");
                }
            }
        }catch (PlatformException e){
            LOGGER.error("登录异常",e);
            modelAndView.addObject("LOGIN_MSG","1000");
        }catch (Exception e){
            LOGGER.error("登录异常",e);
            modelAndView.addObject("LOGIN_MSG","1000");
        }

        return modelAndView;
    }


    @RequestMapping(value = WebSystemConsts.LOGIN_URL,method = RequestMethod.POST)
    @ResponseBody
    public ResultVo login1(HttpServletRequest request,String userName,String password,String verifyCode){
        LOGGER.info("【登录】-->   用户:["+userName+"]开始登录!");
        HttpSession session = request.getSession();
        ResultVo resultVo = new ResultVo();
        UserInfo loginUser = null;

        try {
            // step1: 检查参数
            if(checkUserInfo(resultVo,userName,password)&&checkVerifyCode(session,resultVo,verifyCode)){
                LOGGER.info("【登录】   用户:["+userName+"]开始登录!");
                // step2: 登录
                loginUser = userInfoService.getUserInfoForLogin(userName,password);
                if(loginUser!=null){
                    // step3: 设置session登录信息
                    setSessionForLogin(request,loginUser);
                    resultVo.setResultCode("0000");
                    resultVo.setResultMsg("/my/eventIndex/index");
                }else{
                    resultVo.setResultCode("9999");
                    resultVo.setResultMsg("用户邮箱或密码错误！");
                }
            }
        }catch (PlatformException e){
            LOGGER.error("登录异常",e);
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("网络异常请稍后再试！");
        }catch (Exception e){
            LOGGER.error("登录异常",e);
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("网络异常请稍后再试！");
        }
        LOGGER.info("【登录】<--   用户:["+userName+"]开始登录!");
        return resultVo;
    }

    /**
     * 检查用户登录的邮箱、密码信息
     * @param resultVo
     * @param userName
     * @param password
     * @return
     */
    private boolean checkUserInfo(ResultVo resultVo,String userName,String password){

        if(StringUtils.isBlank(userName)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("用户邮箱不能为空！");
            return false;
        }
        if(!RegExpValidator.isEmail(userName)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("用户邮箱格式错误！");
            return false;
        }
        if(StringUtils.isBlank(password)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("用户密码不能为空！");
            return false;
        }
        return true;
    }

    /**
     * 检查图片验证码信息
     * @param session
     * @param resultVo
     * @param verifyCode
     * @return
     */
    private boolean checkVerifyCode(HttpSession session,ResultVo resultVo,String verifyCode){

        if(StringUtils.isBlank(verifyCode)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("请输入验证码！");
            return false;
        }

        String vCode = getVerifyCode(session);
        if(!verifyCode.equalsIgnoreCase(vCode)){
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("验证码错误！");
            return false;
        }

        return true;
    }

    /**
     * 获取图片验证码内容
     * @param session
     * @return
     */
    private String getVerifyCode(HttpSession session){
        String vCode = (String)session.getAttribute(WebCommonConstant.LOGIN_VERIFY_CODE);
        return vCode;
    }

    /**
     * 登录成功后，设置session信息
     * @param request
     * @param userInfo
     */
    private void setSessionForLogin(HttpServletRequest request,UserInfo userInfo){
        HttpSession session = request.getSession();
        // 设置之前的 session失效
        session.invalidate();
        session = request.getSession();
        session.setAttribute(WebSystemConsts.COOKIE_USER,userInfo.getUserName());
        session.setMaxInactiveInterval(WebCommonConstant.COOKIE_LOGIN_IN_OUTTIME);
    }

}
