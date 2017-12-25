package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.domain.Order;
import com.hexiaofei.springeurekaclient.service.IOrderService;
import com.hexiaofei.springeurekaclient.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by hexiaofei on 2017/12/23.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);


    @Value("${key}")
    private String servername;

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(){

        int orderId = 500;
        for(int i = 1010; i< 1020; i++){
            do {
                String orderName = "订单-"+i+"-"+orderId;
                LOGGER.info("【插入订单】用户ID={}， 订单号={}， 订单名称={}",i,orderId,orderName);
                userService.addUser(i, orderId, orderName);
            }while(++orderId % 10 > 0);
        }
        return "0000";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Map> findList(){
        List<Map> list = userService.getListMap();
        return list;
    }

    @RequestMapping("/byUserId/{userId}")
    @ResponseBody
    public List<Order> findOrderByUserId(@PathVariable("userId") Integer userId){

        List<Order> list = orderService.getOrderByUserId(userId);

        return list;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Order> findAllOrderList(){

        List<Order> list = orderService.getAllOrderList();

        return list;
    }
}
