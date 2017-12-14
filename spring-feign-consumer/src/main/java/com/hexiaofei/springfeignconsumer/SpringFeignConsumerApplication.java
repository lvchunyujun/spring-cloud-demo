package com.hexiaofei.springfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
public class SpringFeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignConsumerApplication.class, args);
	}
}
