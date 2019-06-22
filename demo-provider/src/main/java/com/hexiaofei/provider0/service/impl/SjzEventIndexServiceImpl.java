package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzEventIndexMapper;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("sjzEventIndexService")
public class SjzEventIndexServiceImpl implements SjzEventIndexService {

    @Autowired
    private SjzEventIndexMapper sjzEventIndexMapper;
    @Override
    public int addObject(SjzEventIndex mob) throws PlatformException {
        return 0;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzEventIndex mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzEventIndex getObjectById(int id) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<SjzEventIndex> getPageVoObject(PageVo<SjzEventIndex> pageVo) throws PlatformException {

        List<SjzEventIndex> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzEventIndexMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzEventIndexMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzEventIndex> getAllObject() throws PlatformException {
        return null;
    }
}
