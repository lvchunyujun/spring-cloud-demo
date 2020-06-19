package com.hexiaofei.sjzclient.web.security;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * URL异常状态控制器
 */
@Controller
public class ExceptionStatusController implements ErrorController {

    private final static String WEB_STATUS_URL = "common/";

    @RequestMapping("error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return "401";
        }else if(statusCode == 404){
            return WEB_STATUS_URL+"lsz_404";
        }else{
            return WEB_STATUS_URL+"lsz_500";
        }

    }
    @Override
    public String getErrorPath() {
        return "error";
    }
}
