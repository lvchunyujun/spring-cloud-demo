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
        UserDaoShardingImpl userDaoSharding = new UserDaoShardingImpl();
        userDaoSharding.selectUserById(id);
        for(int i = 1000; i< 1010 ; i++ ){
            for(int j = 310 ; j < 350 ; j++ ){
                userDaoSharding.inertObject(i,j+(i%1000));
            }
        }
        return user;
    }
}
