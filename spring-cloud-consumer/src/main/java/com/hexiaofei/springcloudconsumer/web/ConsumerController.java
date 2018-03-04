package com.hexiaofei.springcloudconsumer.web;

import com.hexiaofei.springcloudconsumer.domain.Order;
import com.hexiaofei.springcloudconsumer.domain.User;
import com.hexiaofei.springcloudconsumer.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */
@RestController
@RequestMapping("/cum")
public class ConsumerController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/{id}")
    @ResponseBody
    public User findUserById(@PathVariable Integer id){
        User user  = consumerService.findUserById(id);
        LOGGER.info("【查询客户信息】   id="+id);
        return user;
    }

    @RequestMapping("/order/{id}")
    @ResponseBody
    public List<Order> getOrderListByUserId(@PathVariable Integer id){
        List<Order> list = consumerService.findOrderListByUserId(id);
        return list;
    }
}
