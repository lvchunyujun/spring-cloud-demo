package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzSpiderWebsiteMapper;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("sjzSpiderWebsiteService")
public class SjzSpiderWebsiteServiceImpl implements SjzSpiderWebsiteService {

    @Autowired
    private SjzSpiderWebsiteMapper sjzSpiderWebsiteMapper;

    @Override
    public int addObject(SjzSpiderWebsite mob) throws PlatformException {
        int result = sjzSpiderWebsiteMapper.insert(mob);
        return result;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzSpiderWebsite mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzSpiderWebsite getObjectById(int id) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<SjzSpiderWebsite> getPageVoObject(PageVo<SjzSpiderWebsite> pageVo) throws PlatformException {
        return null;
    }

    @Override
    public List<SjzSpiderWebsite> getAllObject() throws PlatformException {
        return null;
    }
}
