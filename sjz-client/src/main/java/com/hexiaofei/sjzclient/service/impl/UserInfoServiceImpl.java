package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.common.WebSystemConsts;
import com.hexiaofei.sjzclient.dao.mapper.UserInfoMapper;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.UserInfoService;
import com.hexiaofei.sjzclient.service.base.AbstractService;
import com.hexiaofei.sjzclient.utils.security.MD5;
import com.hexiaofei.sjzclient.vo.PageVo;
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
public class UserInfoServiceImpl extends AbstractService implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoForLogin(String userName, String password) throws PlatformException {
        password = MD5.encodeByMd5AndSalt(password);
        return userInfoMapper.selectUserInfoForLogin(userName,password);
    }

    @Override
    public int addObject(UserInfo userInfo) throws PlatformException {
        userInfo.setPassword(MD5.encodeByMd5AndSalt(WebSystemConsts.DFAULT_PASSWORD));
        userInfo.setLoginCount(0);
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(UserInfo userInfo) throws PlatformException {
        int resultId = -1;
        UserInfo targetObj = getObjectById(userInfo.getId());
        targetObj = refreshObjectForNotNullVal(targetObj,userInfo);
        resultId = userInfoMapper.updateByPrimaryKey(targetObj);
        return resultId;
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
