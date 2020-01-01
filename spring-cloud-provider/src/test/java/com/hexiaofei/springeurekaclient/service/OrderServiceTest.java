package com.hexiaofei.springeurekaclient.service;

import com.hexiaofei.springeurekaclient.SpringCloudProviderApplication;
import com.hexiaofei.springeurekaclient.domain.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by hexiaofei on 2018/2/3.
 */
@SpringBootTest(classes = SpringCloudProviderApplication.class,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class OrderServiceTest {

    @Autowired
    private IOrderService orderService;

    @Test
    public void testGetOrderByUserId(){
        System.out.println("【获取order】--->");
        int userId = 1000;
        List<Order> orderList = orderService.getOrderByUserId(userId);
        for(int i = 0 ; i < orderList.size() ; i++ ){
            Order order = orderList.get(i);
            System.out.println(order);
        }
        System.out.println("【获取order】<---");
    }
}
