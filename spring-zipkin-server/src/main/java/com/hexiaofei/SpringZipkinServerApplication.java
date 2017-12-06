package com.hexiaofei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class SpringZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZipkinServerApplication.class, args);
	}
}
