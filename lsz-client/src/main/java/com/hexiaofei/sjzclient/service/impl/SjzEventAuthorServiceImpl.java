package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.dao.mapper.SjzEventAuthorMapper;
import com.hexiaofei.sjzclient.domain.SjzEventAuthor;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.SjzEventAuthorService;
import com.hexiaofei.sjzclient.service.base.AbstractService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sjzEventAuthorService")
public class SjzEventAuthorServiceImpl extends AbstractService implements SjzEventAuthorService {

    @Autowired
    private SjzEventAuthorMapper sjzEventAuthorMapper;

    @Override
    public int addObject(SjzEventAuthor mob) throws PlatformException {
        return sjzEventAuthorMapper.insert(mob);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzEventAuthorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzEventAuthor updateObj) throws PlatformException {
        SjzEventAuthor targetObj = getObjectById(updateObj.getId());
        targetObj = refreshObjectForNotNullVal(targetObj,updateObj);
        return sjzEventAuthorMapper.updateByPrimaryKey(targetObj);
    }

    @Override
    public SjzEventAuthor getObjectById(int id) throws PlatformException {
        return sjzEventAuthorMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<SjzEventAuthor> getPageVoObject(PageVo<SjzEventAuthor> pageVo) throws PlatformException {
        List<SjzEventAuthor> list = new ArrayList<>();

        return pageVo;
    }

    @Override
    public List<SjzEventAuthor> getAllObject() throws PlatformException {
        return null;
    }
}
