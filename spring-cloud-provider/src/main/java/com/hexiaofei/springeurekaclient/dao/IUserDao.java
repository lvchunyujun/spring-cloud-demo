package com.hexiaofei.springeurekaclient.dao;

import com.hexiaofei.springeurekaclient.domain.User;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface IUserDao {

    User selectUserById(int id);

    void inertObject();
}
