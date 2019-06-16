package com.hexiaofei.provider0;

import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.service.IUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserInfoService {

    @Autowired
    private IUserInfoService userInfoService;

    @Test
    public void test(){
        UserInfo userInfo = userInfoService.getUserInfoById(2);
        System.out.println(userInfo);
    }
}
