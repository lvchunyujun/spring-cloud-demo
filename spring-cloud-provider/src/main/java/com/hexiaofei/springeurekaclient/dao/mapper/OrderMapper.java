package com.hexiaofei.springeurekaclient.dao.mapper;

import com.hexiaofei.springeurekaclient.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface OrderMapper {

    List<Order> selectOrderByUserId(@Param("userId") int userId);

    List<Order> selectAllOrderList();
}
