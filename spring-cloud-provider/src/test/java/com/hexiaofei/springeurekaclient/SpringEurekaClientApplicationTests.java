package com.hexiaofei.springeurekaclient;

import com.hexiaofei.springeurekaclient.domain.User;
import com.hexiaofei.springeurekaclient.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 单元测试：  service接口
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringEurekaClientApplicationTests {

	@Autowired
	IUserService userService;

	@Test
	public void contextLoads() {
		Map map = new HashMap();
		System.out.println(1<30);
	}

	@Test
	public void getUserById(){
		User user = userService.getUserById(1);
		System.out.println(user.getName());
	}

}
