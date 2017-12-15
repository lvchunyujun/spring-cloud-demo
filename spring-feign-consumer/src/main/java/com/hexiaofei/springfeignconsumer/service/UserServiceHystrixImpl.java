package com.hexiaofei.springfeignconsumer.service;

import com.hexiaofei.springfeignconsumer.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2017/11/20.
 */
@Component
public class UserServiceHystrixImpl implements UserService{

    @Override
    public User getUserById(@PathVariable(value = "id") Integer id) {
        return null;
    }
}
