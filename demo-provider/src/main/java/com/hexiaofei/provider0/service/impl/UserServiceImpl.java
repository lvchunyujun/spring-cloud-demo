package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.UserMapper;
import com.hexiaofei.provider0.domain.User;
import com.hexiaofei.provider0.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return user;
    }
}
