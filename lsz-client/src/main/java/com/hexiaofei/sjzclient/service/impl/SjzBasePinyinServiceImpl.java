package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.dao.mapper.SjzBasePinyinMapper;
import com.hexiaofei.sjzclient.domain.SjzBasePinyin;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.ISjzBasePinyinService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("sjzBasePinyinService")
public class SjzBasePinyinServiceImpl implements ISjzBasePinyinService {

    @Autowired
    private SjzBasePinyinMapper sjzBasePinyinMapper;

    @Override
    public int addObject(SjzBasePinyin mob) throws PlatformException {
        return 0;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzBasePinyin mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzBasePinyin getObjectById(int id) throws PlatformException {
        SjzBasePinyin sjzBasePinyin = sjzBasePinyinMapper.selectByPrimaryKey(id);
        return sjzBasePinyin;
    }

    @Override
    public PageVo<SjzBasePinyin> getPageVoObject(PageVo<SjzBasePinyin> pageVo) throws PlatformException {
        return null;
    }

    @Override
    public List<SjzBasePinyin> getAllObject() throws PlatformException {
        return null;
    }

    @Override
    public int getCountByAll() {
        int count = sjzBasePinyinMapper.selectCountByAll();
        return count;
    }
}
