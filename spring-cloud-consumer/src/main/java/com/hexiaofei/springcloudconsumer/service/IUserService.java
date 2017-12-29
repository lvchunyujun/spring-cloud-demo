package com.hexiaofei.springcloudconsumer.service;

import com.hexiaofei.springcloudconsumer.domain.User;

/**
 * Created by Administrator on 2017/12/29.
 */
public interface IUserService extends IBaseService<User>{

    User getUserById(Integer id);

    int updateUserById(User user);
}
