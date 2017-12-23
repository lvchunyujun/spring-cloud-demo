package com.hexiaofei.springeurekaclient.service;

import com.hexiaofei.springeurekaclient.SpringCloudProviderApplication;
import com.hexiaofei.springeurekaclient.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by Administrator on 2017/12/22.
 */

/**
 * RANDOM_PORT : 模拟真实servlet 环境
 */
@SpringBootTest(classes = SpringCloudProviderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserServiceTest extends BaseServiceTest{

    @Autowired
    private IUserService userService;


    @Test
    public void indexServiceTest() {
        Integer userId = 132132;
        User user = userService.getUserById(userId);
        Assert.assertEquals("【根据userId查询用户信息】",user.getId(),userId);
    }




}
