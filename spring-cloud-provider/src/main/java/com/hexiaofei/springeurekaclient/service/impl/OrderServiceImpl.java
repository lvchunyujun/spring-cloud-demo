package com.hexiaofei.springeurekaclient.service.impl;

import com.hexiaofei.springeurekaclient.dao.mapper.OrderMapper;
import com.hexiaofei.springeurekaclient.domain.Order;
import com.hexiaofei.springeurekaclient.domain.PageVo;
import com.hexiaofei.springeurekaclient.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int addObject(Order order) {
        int resultId = orderMapper.insertObject(order);
        return resultId;
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
    public PageVo getListByPageVo(PageVo pageVo,Map<String, Object> paraMap) {
        Map<String,Object> parasMap = new HashMap<>();
        int startNo = (pageVo.getPageNo()-1)*pageVo.getPageSize();
        parasMap.put("startNo",startNo);
        parasMap.put("pageSize",pageVo.getPageSize());
        parasMap.putAll(paraMap);
        List<Order> list = orderMapper.selectListByPage(parasMap);
        pageVo.setList(list);
        int pageTotal = orderMapper.selectAllOrderCount();
        pageVo.setPageTotal(pageTotal);
        return pageVo;
    }

    @Override
    public int updateByOrderId(Order order) {
        return orderMapper.updateByOrderId(order);
    }
}
