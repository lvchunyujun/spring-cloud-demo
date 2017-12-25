package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.SpringCloudProviderApplication;
import com.hexiaofei.springeurekaclient.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.RequestBuilder;

/**
 * Created by Administrator on 2017/12/15.
 */
@SpringBootTest(classes = SpringCloudProviderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest  {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void testGetUserById(){
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        User user = testRestTemplate.getForObject("/user/102931",User.class);
        System.out.println("User: "+user);
    }
}
