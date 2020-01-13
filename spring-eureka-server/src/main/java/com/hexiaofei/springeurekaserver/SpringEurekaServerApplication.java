package com.hexiaofei.springeurekaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringEurekaServerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringEurekaServerApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Eureka-Server start……");
		SpringApplication.run(SpringEurekaServerApplication.class, args);
	}


}
