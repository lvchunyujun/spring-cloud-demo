package com.hexiaofei.springeurekaclient.service.impl;

import com.hexiaofei.springeurekaclient.dao.mapper.OrderMapper;
import com.hexiaofei.springeurekaclient.domain.Order;
import com.hexiaofei.springeurekaclient.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addObject(Order order) {
        return 0;
    }

    @Override
    public int deleteObjectById(Integer id) {
        return 0;
    }

    @Override
    public int updateObjectById(Integer id) {
        return 0;
    }

    @Override
    public Order getObjectById(Integer id) {
        return null;
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        List<Order> list = orderMapper.selectOrderByUserId(userId);
        return list;
    }

    @Override
    public List<Order> getAllOrderList() {
        return orderMapper.selectAllOrderList();
    }
}
