package com.hexiaofei.provider0.web.security;

import com.hexiaofei.provider0.common.WebSystemConsts;
import com.hexiaofei.provider0.web.AbstractBaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController extends AbstractBaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogoutController.class);

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("/common/login");
        try {
            request.getSession().removeAttribute(WebSystemConsts.COOKIE_USER);
            request.getSession().invalidate();
            LOGGER.info("用户退出,清除session 和cookie");
        } catch (Exception e) {
            LOGGER.error("用户退出系统异常！",e);
        }
        return modelAndView;
    }

}
