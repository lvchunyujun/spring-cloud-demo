package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.UserInfoMapper;
import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.UserInfoService;
import com.hexiaofei.provider0.utils.security.MD5;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
@Transactional
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoForLogin(String userName, String password) throws PlatformException {
        password = MD5.encodeByMd5AndSalt(password);
        return userInfoMapper.selectUserInfoForLogin(userName,password);
    }

    @Override
    public int addObject(UserInfo mob) throws PlatformException {
        return userInfoMapper.insert(mob);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(UserInfo mob) throws PlatformException {
        return userInfoMapper.updateByPrimaryKey(mob);
    }

    @Override
    public UserInfo getObjectById(int id) throws PlatformException {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<UserInfo> getPageVoObject(PageVo<UserInfo> pageVo) throws PlatformException {
        List<UserInfo> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = userInfoMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = userInfoMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<UserInfo> getAllObject() throws PlatformException {
        return null;
    }
}
