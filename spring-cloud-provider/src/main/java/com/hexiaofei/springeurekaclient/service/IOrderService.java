package com.hexiaofei.springeurekaclient.service;

import com.hexiaofei.springeurekaclient.domain.Order;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface IOrderService extends IBaseService<Order>{

    List<Order> getOrderByUserId(int userId);

    List<Order> getAllOrderList();
}
