package com.hexiaofei.sjzclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.hexiaofei.sjzclient.dao.mapper"}) // 定时任务
@ComponentScan(basePackages = {"com.hexiaofei.sjzclient.service","com.hexiaofei.sjzclient.web"})
public class SjzClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SjzClientApplication.class, args);
	}
}
