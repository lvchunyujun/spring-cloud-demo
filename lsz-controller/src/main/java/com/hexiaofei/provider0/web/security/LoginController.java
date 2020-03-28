package com.hexiaofei.provider0.web.security;

import com.hexiaofei.provider0.common.WebSystemConsts;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.UserInfoService;
import com.hexiaofei.provider0.web.AbstractBaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends AbstractBaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = WebSystemConsts.ADMIN_TOLOGIN_URL)
    public String toLogin(){
        return "/common/login";
    }

    @RequestMapping(value = WebSystemConsts.ADMIN_LOGIN_URL,method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, UserInfo userInfo){

        ModelAndView modelAndView = new ModelAndView("/index");

        try {
            HttpSession session = request.getSession();
            session.invalidate();

            UserInfo login_user = userInfoService.getUserInfoForLogin(userInfo.getUserName(),userInfo.getPassword());

            if(login_user!=null){
                session = request.getSession();
                session.setAttribute(WebSystemConsts.COOKIE_USER,login_user);
                session.setMaxInactiveInterval(WebSystemConsts.COOKIE_OUTTIME);
                modelAndView.addObject("LOGIN_MSG","0000");
            }else{
                modelAndView.setViewName("/common/login");
                modelAndView.addObject("LOGIN_MSG","1000");
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


}
