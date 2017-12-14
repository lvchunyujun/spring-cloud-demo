package com.hexiaofei.springeurekaclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@MapperScan("com.hexiaofei.springeurekaclient.dao")
@SpringBootApplication
@EnableHystrix
public class SpringCloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProviderApplication.class, args);
	}
}
