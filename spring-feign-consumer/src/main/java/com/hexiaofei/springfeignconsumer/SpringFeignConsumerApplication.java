package com.hexiaofei.springfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class SpringFeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignConsumerApplication.class, args);
	}
}
