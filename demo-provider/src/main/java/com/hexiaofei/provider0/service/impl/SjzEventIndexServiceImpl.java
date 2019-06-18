package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzEventIndexMapper;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        return null;
    }

    @Override
    public List<SjzEventIndex> getAllObject() throws PlatformException {
        return null;
    }
}
