package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzDomainInfoMapper;
import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("sjzDomainInfoService")
public class SjzDomainInfoServiceImpl implements SjzDomainInfoService {

    @Autowired
    private SjzDomainInfoMapper sjzDomainInfoMapper;
    @Override
    public int addObject(SjzDomainInfo mob) throws PlatformException {
        int result = sjzDomainInfoMapper.insert(mob);
        return result;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzDomainInfo mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzDomainInfo getObjectById(int id) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<SjzDomainInfo> getPageVoObject(PageVo<SjzDomainInfo> pageVo) throws PlatformException {
        return null;
    }

    @Override
    public List<SjzDomainInfo> getAllObject() throws PlatformException {
        return null;
    }
}
