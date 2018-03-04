package com.hexiaofei.springcloudconsumer.service;


import com.hexiaofei.springcloudconsumer.domain.Order;
import com.hexiaofei.springcloudconsumer.domain.PageVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
@FeignClient(value = "spring-cloud-provider-0")
public interface IOrderService extends IBaseService<Order>{

    @RequestMapping(value="/order/modify/{orderId}",method = RequestMethod.POST)
    int updateByOrderId(@PathVariable("orderId") Integer orderId, Short status);

    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    List<Order> getOrderByUserId(int userId);

    @RequestMapping(value = "/order/deleteAll", method = RequestMethod.DELETE)
    int deleteAllOrder();

    @RequestMapping(method = RequestMethod.DELETE)
    int deleteObjectById(Integer id);

    @RequestMapping(method = RequestMethod.PUT)
    int addObject(Order order);

    @RequestMapping(method = RequestMethod.POST)
    int updateObjectById(Integer id);

    @RequestMapping(method = RequestMethod.GET)
    Order getObjectById(Integer id);

}
