package com.hexiaofei.provider0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@MapperScan("com.hexiaofei.provider0.dao")
@SpringBootApplication
@EnableHystrix
public class DemoProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProviderApplication.class, args);
	}

}
