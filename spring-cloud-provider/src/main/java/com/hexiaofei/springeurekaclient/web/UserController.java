package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.domain.User;
import com.hexiaofei.springeurekaclient.service.IUserService;
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

    @RequestMapping("/{id}")
    @ResponseBody
    public User findUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("查询客户id={},详情{}",id,user);
        return user;
    }

    @Autowired
    private IUserService userService;
}
