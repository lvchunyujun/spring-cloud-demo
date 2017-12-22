package com.hexiaofei.springeurekaclient.service;

import com.hexiaofei.springeurekaclient.SpringCloudProviderApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Created by Administrator on 2017/12/22.
 */

/**
 * RANDOM_PORT : 模拟真实servlet 环境
 */
@SpringBootTest(classes = SpringCloudProviderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest extends BaseServiceTest{

    @Autowired
    private IUserService userService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void indexServiceTest() {
        Integer userId = 132132;
        userService.getUserById(userId);
    }




}
