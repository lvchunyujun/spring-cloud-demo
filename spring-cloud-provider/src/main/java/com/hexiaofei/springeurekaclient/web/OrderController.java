package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.common.redis.RedisUtil;
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



//    @Value("${key}")
    private String servername;

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(){

        int orderId = 1;
        for(int i = 1000; i< 10000; i++){
            do {
                String orderName = "订单-"+i+"-"+orderId;
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(i);
                order.setOrderName(orderName);
                order.setCreateTime(new Date());
                orderService.addObject(order);
                LOGGER.info("【插入订单】用户ID={}， 订单号={}， 订单名称={}",i,orderId,orderName);
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
        paraMap.put("startTime","2017-12-30 16:30:00");
        paraMap.put("endTime","2017-12-30 16:35:00");

        pageVo = orderService.getListByPageVo(pageVo,paraMap);

        convertPageVo(pageVo);
        ResultVo resultVo = new ResultVo();
        resultVo.setResultCode("0000");
        resultVo.setResultMsg("查询成功");
        resultVo.setPageVo(pageVo);
        return resultVo;
    }

    @ResponseBody
    @RequestMapping("/modify/{orderId}")
    public ResultVo updateOrderByOrderId(@PathVariable("orderId") Integer orderId,Short status){
        int resultId;
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStatus(status);
        resultId = orderService.updateByOrderId(order);
        ResultVo resultVo = new ResultVo();
        if(resultId==1){
            resultVo.setResultCode("0000");
            resultVo.setResultMsg("修改成功");
        }else{
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("修改失败");
        }
        return resultVo;
    }

    @ResponseBody
    @RequestMapping("/deleteALL")
    public ResultVo deleteAllOrder(){

        ResultVo resultVo = new ResultVo();

        int count = orderService.deleteAllOrder();

        if(count > 0){
            resultVo.setResultCode("0000");
            resultVo.setResultMsg("success!");
        }else{
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("failed!");
        }

        return resultVo;
    }

    @ResponseBody
    @RequestMapping("/addCach")
    public ResultVo addRedisCaching(String username){
        ResultVo resultVo = getResultVo();
        RedisUtil redisUtil = new RedisUtil();
        long count = redisUtil.incrLong("count");
        LOGGER.info("       当前数量："+count);
        if(count>10){
            redisUtil.decrLong("count");
            LOGGER.info("过载   当前数量："+count);
            resultVo.setResultCode("9999");
            resultVo.setResultMsg("服务过载！");
            return resultVo;
        }
        String key = "username"+count;
        redisUtil.set(key,key);
        resultVo.setObject(key);
        try {
            LOGGER.info("睡眠："+key+"   当前数量："+count);
            TimeUnit.SECONDS.sleep(10);
            LOGGER.info("唤醒："+key+"   当前数量："+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        redisUtil.decrLong("count");
        return resultVo;
    }

    @ResponseBody
    @RequestMapping("/getCach")
    public ResultVo getRedisCaching(){
        ResultVo resultVo = getResultVo();
        RedisUtil redisUtil = new RedisUtil();
        String username = redisUtil.get("username");
        resultVo.setObject(username);
        return resultVo;
    }
}
