package com.hexiaofei.provider0.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/8.
 */
@RestController
@RefreshScope
@Configuration
public class ConfigController {

    @Value("${version}")
    private String version;

    @Value("${servername}")
    private String servername;


    @RequestMapping("/server")
    public String getServerInfo(){
        return servername+":"+version;
    }
}
