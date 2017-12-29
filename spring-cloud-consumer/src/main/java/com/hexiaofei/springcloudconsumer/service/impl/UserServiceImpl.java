package com.hexiaofei.springcloudconsumer.service.impl;

import com.hexiaofei.springcloudconsumer.dao.mapper.UserMapper;
import com.hexiaofei.springcloudconsumer.domain.PageVo;
import com.hexiaofei.springcloudconsumer.domain.User;
import com.hexiaofei.springcloudconsumer.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/29.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final static String BASE_URL = "http://SPRING-CLOUD-PROVIDER-0/";
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUserById(User user) {
        int resultId = userMapper.updateUserById(user);
        LOGGER.info("【更新用户积分】   resultId = "+resultId);
        if(true)
        throw new RuntimeException("更新用户信用积分异常！");

        restTemplate.execute(new URI("/user/modify/13385?credit=45"),HttpMethod.POST, null, String.class, user);
        return resultId;
    }

    @Override
    public int addObject(User user) {
        return 0;
    }

    @Override
    public int deleteObjectById(Integer id) {
        return 0;
    }

    @Override
    public int updateObjectById(Integer id) {
        return 0;
    }

    @Override
    public User getObjectById(Integer id) {
        return null;
    }

    @Override
    public PageVo getListByPageVo(PageVo pageVo, Map<String, Object> paraMap) {
        return null;
    }
}
