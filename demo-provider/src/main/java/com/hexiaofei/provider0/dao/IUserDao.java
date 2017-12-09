package com.hexiaofei.provider0.dao;

import com.hexiaofei.provider0.domain.User;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface IUserDao {

    User selectUserById(int id);
}
