package com.hexiaofei.springeurekaclient.service.impl;

import com.hexiaofei.springeurekaclient.dao.mapper.UserMapper;
import com.hexiaofei.springeurekaclient.dao.shardingImpl.UserDaoShardingImpl;
import com.hexiaofei.springeurekaclient.domain.User;
import com.hexiaofei.springeurekaclient.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/1.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        UserDaoShardingImpl userDaoSharding = new UserDaoShardingImpl();
        userDaoSharding.selectUserById(id);
        return user;
    }

    @Override
    public void addUser(int userId,int orderId,String orderName) {
        UserDaoShardingImpl userDaoSharding = new UserDaoShardingImpl();

        userDaoSharding.inertObject(userId , orderId,orderName);
    }

    @Override
    public List<Map> getListMap() {

        UserDaoShardingImpl userDaoSharding = new UserDaoShardingImpl();
        List<Map> list = userDaoSharding.getUserForMax();

        return list;
    }


    public List<Map> getHystrixError(){
        LOGGER.info("【查询用户信息】 触发断路器！！");
        return null;
    }
}
