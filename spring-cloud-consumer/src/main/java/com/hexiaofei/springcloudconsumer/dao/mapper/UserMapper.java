package com.hexiaofei.springcloudconsumer.dao.mapper;

import com.hexiaofei.springcloudconsumer.domain.User;

/**
 * Created by Administrator on 2017/12/29.
 */
public interface UserMapper {

    User selectUserById(Integer id);

    int updateUserById(User user);
}
