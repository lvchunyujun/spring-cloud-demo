package com.hexiaofei.provider0.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIndexController extends AdminBaseController {

    @RequestMapping(value = "/index")
    public String index(ModelMap model){
        return "/index";
    }

}
