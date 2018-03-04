package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.domain.User;
import com.hexiaofei.springeurekaclient.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

//    @Value("${key}")
    private String servername;

    @Autowired
    private IUserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public User findUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);

        /*  熔断器测试
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        LOGGER.info("【{}】查询客户id={},详情{}",servername,id,user);
        return user;
    }






}
