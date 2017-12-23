package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.domain.User;
import com.hexiaofei.springeurekaclient.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Value("${key}")
    private String servername;

    @Autowired
    private IUserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "getHystrixError")
    public User findUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("【{}】查询客户id={},详情{}",servername,id,user);
        return user;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(){

        int orderId = 400;
        for(int i = 1010; i< 1020; i++){
            do {
                String orderName = "订单-"+i+"-"+orderId;
                LOGGER.info("【插入订单】用户ID={}， 订单号={}， 订单名称={}",i,orderId,orderName);
                userService.addUser(i, orderId, orderName);
            }while(++orderId % 10 > 0);
        }
        return "0000";
    }

    public User getHystrixError(Integer id){
        LOGGER.info("【查询用户信息】 触发断路器！！");
        return null;
    }

}
