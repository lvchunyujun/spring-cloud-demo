package com.hexiaofei.provider0;

import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserInfoService {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test() throws PlatformException {
        UserInfo userInfo = userInfoService.getObjectById(10);
        System.out.println(userInfo);
    }

    public static void main(String[] args) {
        int i = 1;

        switch (i){
            case 1:
                System.out.println("1");
            case 2: ;
            System.out.println("defualt");
        }

    }
}
