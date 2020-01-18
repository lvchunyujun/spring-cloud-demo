package com.hexiaofei.provider0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// mybatis配置 在启动类中添加对mapper包扫描@MapperScan

/**
 * 注解顺序不能打乱，否则会出现加载异常：NullPinterException
 */
@EnableTransactionManagement                       // 事物管理
@MapperScan(basePackages = {"com.hexiaofei.provider0.dao.mapper","com.shijianzhou.language.dao.mapper"})
@EnableScheduling                                 // 定时任务
@ComponentScan(basePackages = {"com.hexiaofei.provider0","com.shijianzhou.language"})
@SpringBootApplication
public class DemoProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProviderApplication.class, args);
	}

}
