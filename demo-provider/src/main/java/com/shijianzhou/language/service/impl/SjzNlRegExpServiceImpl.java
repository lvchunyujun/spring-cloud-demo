package com.shijianzhou.language.service.impl;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.AbstractService;
import com.hexiaofei.provider0.vo.PageVo;
import com.shijianzhou.language.dao.mapper.SjzNlRegExpMapper;
import com.shijianzhou.language.domain.SjzNlRegExp;
import com.shijianzhou.language.service.SjzNlRegExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("sjzNlRegExpService")
public class SjzNlRegExpServiceImpl extends AbstractService implements SjzNlRegExpService {

    @Autowired
    private SjzNlRegExpMapper sjzNlRegExpMapper;

    @Override
    public int addObject(SjzNlRegExp sjzNlRegExp) throws PlatformException {
        return sjzNlRegExpMapper.insert(sjzNlRegExp);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzNlRegExp sjzNlRegExp) throws PlatformException {
        int resultId = -1;
        SjzNlRegExp targetObj = getObjectById(sjzNlRegExp.getId());
        targetObj = refreshObjectForNotNullVal(targetObj,sjzNlRegExp);
        resultId = sjzNlRegExpMapper.updateByPrimaryKey(targetObj);
        return resultId;
    }

    @Override
    public SjzNlRegExp getObjectById(int id) throws PlatformException {
        return sjzNlRegExpMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo getPageVoObject(PageVo pageVo) throws PlatformException {
        List<SjzNlRegExp> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzNlRegExpMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzNlRegExpMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzNlRegExp> getAllObject() throws PlatformException {
        return null;
    }

}
