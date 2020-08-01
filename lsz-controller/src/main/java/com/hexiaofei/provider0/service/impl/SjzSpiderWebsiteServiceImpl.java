package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzSpiderWebsiteMapper;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("sjzSpiderWebsiteService")
public class SjzSpiderWebsiteServiceImpl implements SjzSpiderWebsiteService {

    @Autowired
    private SjzSpiderWebsiteMapper sjzSpiderWebsiteMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addObject(SjzSpiderWebsite mob) throws PlatformException {
        int result = sjzSpiderWebsiteMapper.insert(mob);
        return result;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzSpiderWebsiteMapper.deleteByPrimaryKey(id);
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
        List<SjzSpiderWebsite> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzSpiderWebsiteMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzSpiderWebsiteMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzSpiderWebsite> getAllObject() throws PlatformException {
        return null;
    }
}
