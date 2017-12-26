package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.domain.Order;
import com.hexiaofei.springeurekaclient.domain.OrderVo;
import com.hexiaofei.springeurekaclient.domain.PageVo;
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

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by hexiaofei on 2017/12/23.
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{

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

        int orderId = 1005;
        for(int i = 1010; i< 1020; i++){
            do {
                String orderName = "订单-"+i+"-"+orderId;
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(i);
                order.setOrderName(orderName);
                order.setCreateTime(new Date());
                orderService.addObject(order);
                LOGGER.info("【插入订单】用户ID={}， 订单号={}， 订单名称={}",i,orderId,orderName);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

    @ResponseBody
    @RequestMapping("/{pageNo}")
    public ResultVo findAllOrderList(@PathVariable("pageNo") Integer pageNo,Integer pageSize){
        PageVo pageVo = new PageVo();
        if(pageSize!=null){
            pageVo.setPageSize(pageSize);
        }
        pageVo.setPageNo(pageNo);

        Map<String,Object> paraMap = new HashMap();
        paraMap.put("startTime","2017-12-26 23:44:50");
        paraMap.put("endTime","2017-12-26 23:45:00");

        pageVo = orderService.getListByPageVo(pageVo,paraMap);

        convertPageVo(pageVo);
        ResultVo resultVo = new ResultVo();
        resultVo.setResultCode("0000");
        resultVo.setResultMsg("查询成功");
        resultVo.setPageVo(pageVo);
        return resultVo;
    }





}
