package com.hexiaofei.springeurekaclient.service;

import com.hexiaofei.springeurekaclient.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface IUserService {

    User getUserById(Integer id);

    void addUser(int userId,int orderId,String orderName);

    List<Map> getListMap();
}
