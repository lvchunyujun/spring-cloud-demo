package com.hexiaofei.springcloudconsumer.service;


import com.hexiaofei.springcloudconsumer.domain.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
@FeignClient(value = "spring-cloud-provider-0")
public interface IOrderService extends IBaseService<Order>{

    int updateByOrderId(Order order);

    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    List<Order> getOrderByUserId(int userId);
}
