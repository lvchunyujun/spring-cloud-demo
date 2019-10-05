package com.hexiaofei.provider0.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * URL异常状态控制器
 */
@Controller
public class ExceptionStatusController implements ErrorController {



    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return "/401";
        }else if(statusCode == 404){
            return "/common/sjz_404";
        }else if(statusCode == 403){
            return "/403";
        }else{
            return "/500";
        }

    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
