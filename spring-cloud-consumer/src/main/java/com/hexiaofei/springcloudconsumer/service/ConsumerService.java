package com.hexiaofei.springcloudconsumer.service;

import com.hexiaofei.springcloudconsumer.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author he·xiaofei
 * 断路器 :  当消费者调用定义接口过载时
 *           参考：hystrix配置
 * Created by Administrator on 2017/11/17.
 */
@Service
public class ConsumerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getHystrixError")
    public User findUserById(Integer id){
        User user  = restTemplate.getForObject("http://SPRING-CLOUD-PROVIDER-0/user/"+id,User.class);
        return user;
    }

    public User getHystrixError(Integer id){
        LOGGER.error("过载系统异常 id:"+id);
        User user = new User();
        user.setId(-1001);
        return user;
    }
}
