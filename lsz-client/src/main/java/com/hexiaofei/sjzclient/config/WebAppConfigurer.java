package com.hexiaofei.sjzclient.config;


import com.hexiaofei.sjzclient.common.WebSystemConsts;
import com.hexiaofei.sjzclient.web.security.LoginInterceptor;
import com.hexiaofei.sjzclient.web.security.RightsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration          //使用注解 实现拦截
public class WebAppConfigurer implements WebMvcConfigurer {

    @Autowired
    RightsInterceptor rightsInterceptor;

    @Autowired
    LoginInterceptor loginInterceptor;


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录拦截的管理器
        InterceptorRegistration registration =
                registry.addInterceptor(loginInterceptor);      //拦截的对象会进入这个类中进行判断
        registration.addPathPatterns("/**");                    //所有路径都被拦截
        registration.excludePathPatterns("/",
                WebSystemConsts.INDEX_URL,                      // 首页索引
                WebSystemConsts.TO_LOGIN_URL,
                WebSystemConsts.TO_SIGN_IN,
                WebSystemConsts.LOGIN_URL,
                WebSystemConsts.LOGOUT_URL,
                WebSystemConsts.SEND_CHECK_CODE,
                WebSystemConsts.ERROR_URL,
                WebSystemConsts.STATIC_URL);                 //添加不拦截路径
//        super.addInterceptors(registry);


        //权限拦截的管理器
//        InterceptorRegistration registration1 = registry.addInterceptor(rightsInterceptor);
//        registration1.addPathPatterns("/**");                    //所有路径都被拦截
//        registration1.excludePathPatterns("/","/login","/error","/static/**","/logout");       //添加不拦截路径
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
