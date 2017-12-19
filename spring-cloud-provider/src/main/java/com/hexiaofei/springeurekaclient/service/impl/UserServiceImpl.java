package com.hexiaofei.springeurekaclient.service.impl;

import com.hexiaofei.springeurekaclient.dao.IUserDao;
import com.hexiaofei.springeurekaclient.dao.mapper.UserMapper;
import com.hexiaofei.springeurekaclient.dao.shardingImpl.UserDaoShardingImpl;
import com.hexiaofei.springeurekaclient.domain.User;
import com.hexiaofei.springeurekaclient.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/12/1.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        new UserDaoShardingImpl().selectUserById(id);
        return user;
    }
}
