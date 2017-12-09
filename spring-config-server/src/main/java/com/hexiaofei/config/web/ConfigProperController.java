package com.hexiaofei.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/12/6.
 */
@Controller
@RequestMapping("/config")
public class ConfigProperController {




    @RequestMapping("/userName")
    @ResponseBody
    public String getUserName(){
        return null;
    }

}
