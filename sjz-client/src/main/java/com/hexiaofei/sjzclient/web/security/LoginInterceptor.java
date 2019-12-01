package com.hexiaofei.sjzclient.web.security;

import com.hexiaofei.sjzclient.common.WebSystemConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Repository
public class LoginInterceptor implements HandlerInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {       //请求进入这个拦截器
        HttpSession session = request.getSession();
        Object user_cookie = session.getAttribute(WebSystemConsts.COOKIE_USER);
        if(user_cookie == null){       //判断session中有没有user信息
            LOGGER.info("用户未登录！");
            if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){
                response.sendError(401);
            }
            response.sendRedirect(WebSystemConsts.TO_LOGIN_URL);     //没有user信息的话进行路由重定向
            return false;
        }
        return true;        //有的话就继续操作
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
