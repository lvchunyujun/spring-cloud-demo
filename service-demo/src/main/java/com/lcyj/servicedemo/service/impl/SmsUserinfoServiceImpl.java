package com.lcyj.servicedemo.service.impl;

import com.lcyj.common.vo.PageVo;
import com.lcyj.servicedemo.dao.mapper.SmsUserinfoMapper;
import com.lcyj.servicedemo.exception.PlatformException;
import com.lcyj.servicedemo.model.SmsUserinfo;
import com.lcyj.servicedemo.service.SmsUserinfoService;
import com.lcyj.servicedemo.service.base.AbstractService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SmsUserinfoServiceImpl extends AbstractService implements SmsUserinfoService {

    @Autowired
    private SmsUserinfoMapper smsUserinfoMapper;


    @Override
    public int addObject(SmsUserinfo mob) throws PlatformException {
        return smsUserinfoMapper.insert(mob);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return smsUserinfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SmsUserinfo mob) throws PlatformException {

        SmsUserinfo smsUserinfo = getObjectById(mob.getId());
        smsUserinfo = refreshObjectForNotNullVal(smsUserinfo,mob);
        return smsUserinfoMapper.updateByPrimaryKey(mob);
    }

    @Override
    public SmsUserinfo getObjectById(int id)  {
        return smsUserinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<SmsUserinfo> getPageVoObject(PageVo<SmsUserinfo> pageVo)  {
        List<SmsUserinfo> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = smsUserinfoMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = smsUserinfoMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public PageVo<SmsUserinfo> getPageVoByObject(PageVo<SmsUserinfo> pageVo, SmsUserinfo mob) {
        return null;
    }

    @Override
    public PageVo<SmsUserinfo> getPageVoByMap(PageVo<SmsUserinfo> pageVo, Map<String, Object> map)  {
        return null;
    }

    @Override
    public List<SmsUserinfo> getAllObject()  {
        return null;
    }

    @Override
    public Cursor<SmsUserinfo> getCursorByObject(SmsUserinfo mob)  {
        return null;
    }

    @Override
    public Cursor<SmsUserinfo> getCursorByMap(Map<String, Object> map)  {
        return null;
    }
}
