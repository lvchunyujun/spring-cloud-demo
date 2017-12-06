package com.hexiaofei.zuuluser.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/22.
 */
@Component
public class UserFilter extends ZuulFilter{

    private final static Logger LOGGER = LoggerFactory.getLogger(UserFilter.class);

    private static final String FILTER_TYPE_PRE = "pre";
    private static final String FILTER_TYPE_ROUTING = "routing";
    private static final String FILTER_TYPE_POST = "post";
    private static final String FILTER_TYPE_ERROR = "error";

    @Override
    public String filterType() {
        return FILTER_TYPE_PRE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     */
    @Override
    public Object run() {
        LOGGER.info("【拦截器】-->");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        String flag = request.getParameter("flag");
        if(true){
            LOGGER.info("【拦截器】   用户已登录！ ");
            requestContext.setSendZuulResponse(true);   // 对该请求进行路由
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess", true);      // 设值，让下一个Filter看到上一个Filter的状态
            return null;
        }else{
            LOGGER.info("【拦截器】   用户未登录状态！ ");
            requestContext.setSendZuulResponse(false);   // 对该请求进行路由
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("{\"result\":\"password is not correct!\"}");
            requestContext.set("isSuccess", false);      // 设值，让下一个Filter看到上一个Filter的状态
            return null;
        }
    }
}
