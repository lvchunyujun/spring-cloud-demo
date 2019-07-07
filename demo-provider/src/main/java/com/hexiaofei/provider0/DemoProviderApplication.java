package com.hexiaofei.provider0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

// mybatis配置 在启动类中添加对mapper包扫描@MapperScan

@SpringBootApplication
@EnableHystrix
@EnableTransactionManagement                       // 事物管理
@MapperScan("com.hexiaofei.provider0.dao.mapper")
@EnableScheduling                                 // 定时任务
@ComponentScan(basePackages = {"com.hexiaofei.provider0"})
public class DemoProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProviderApplication.class, args);
	}

}
