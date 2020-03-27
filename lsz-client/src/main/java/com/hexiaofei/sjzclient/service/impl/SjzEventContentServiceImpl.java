package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.domain.SjzEventContent;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.SjzEventContentService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("sjzEventContentService")
public class SjzEventContentServiceImpl implements SjzEventContentService {

    @Override
    public int addObject(SjzEventContent mob) throws PlatformException {
        return 0;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzEventContent mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzEventContent getObjectById(int id) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<SjzEventContent> getPageVoObject(PageVo<SjzEventContent> pageVo) throws PlatformException {
        return null;
    }

    @Override
    public List<SjzEventContent> getAllObject() throws PlatformException {
        return null;
    }
}
