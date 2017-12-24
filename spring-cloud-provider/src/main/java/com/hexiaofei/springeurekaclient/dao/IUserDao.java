package com.hexiaofei.springeurekaclient.dao;

import com.hexiaofei.springeurekaclient.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface IUserDao {

    User selectUserById(int id);

    void inertObject();

    void inertObject(int user_id,int order_id,String order_name);

    List<Map> getUserForMax();
}
