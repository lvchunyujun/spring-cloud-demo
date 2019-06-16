package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.UserInfoMapper;
import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/12/1.
 */
@Transactional
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoById(Integer id) {
        UserInfo userInfo = null;
        userInfo = userInfoMapper.selectUserInfoById(id);
        return userInfo;
    }
}
