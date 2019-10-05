package com.shijianzhou.language.service.impl;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.vo.PageVo;
import com.shijianzhou.language.dao.mapper.SjzNlWordMetaMapper;
import com.shijianzhou.language.domain.SjzNlWordMeta;
import com.shijianzhou.language.service.SjzNlWordMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Controller("sjzNlWordMetaService")
public class SjzNlWordMetaServiceImpl implements SjzNlWordMetaService {

    @Autowired
    private SjzNlWordMetaMapper sjzNlWordMetaMapper;

    @Override
    public boolean getNlRegExpCheck(SjzNlWordMeta sjzNlWordMeta) throws PlatformException {
        return false;
    }

    @Override
    public SjzNlWordMeta getObjectForRegExp(SjzNlWordMeta sjzNlWordMeta) throws PlatformException {
        return null;
    }

    @Override
    public boolean getMarchResultForRegExpCode(String targetStr, String regExpCode) throws PlatformException {
        return false;
    }

    @Override
    public List<String> getListMarchForRegExpCode(String targetStr, String regExpCode) throws PlatformException {
        return null;
    }

    @Override
    public int addObject(SjzNlWordMeta mob) throws PlatformException {
        return sjzNlWordMetaMapper.insert(mob);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzNlWordMetaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzNlWordMeta mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzNlWordMeta getObjectById(int id) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<SjzNlWordMeta> getPageVoObject(PageVo<SjzNlWordMeta> pageVo) throws PlatformException {
        List<SjzNlWordMeta> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzNlWordMetaMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzNlWordMetaMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzNlWordMeta> getAllObject() throws PlatformException {
        return null;
    }
}
