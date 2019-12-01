package com.hexiaofei.sjzclient.web;

import com.hexiaofei.sjzclient.entity.User;
import com.hexiaofei.sjzclient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/11/20.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id") Integer id){
        LOGGER.info("【查询客户信息】   id="+id);
        return userService.getUserById(id);
    }


}
