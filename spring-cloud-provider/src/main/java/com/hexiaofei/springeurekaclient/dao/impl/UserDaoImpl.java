package com.hexiaofei.springeurekaclient.dao.impl;

import com.hexiaofei.springeurekaclient.dao.IUserDao;
import com.hexiaofei.springeurekaclient.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/1.
 */

public class UserDaoImpl implements IUserDao{
    @Override
    public User selectUserById(int id) {


        return null;
    }

    @Override
    public void inertObject() {

    }

    @Override
    public void inertObject(int user_id, int order_id) {

    }
}
