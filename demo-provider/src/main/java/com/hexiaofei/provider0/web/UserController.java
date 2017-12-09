package com.hexiaofei.provider0.web;

import com.hexiaofei.provider0.domain.User;
import com.hexiaofei.provider0.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private IUserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public User findUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("【{}】查询客户id={},详情{}",id,user);
        return user;
    }
}
