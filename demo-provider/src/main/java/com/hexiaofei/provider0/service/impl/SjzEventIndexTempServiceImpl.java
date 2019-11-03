package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzEventIndexTempMapper;
import com.hexiaofei.provider0.domain.SjzEventIndexTemp;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexTempService;
import com.hexiaofei.provider0.vo.PageVo;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sjzEventIndexTemp")
public class SjzEventIndexTempServiceImpl implements SjzEventIndexTempService {

    @Autowired
    private SjzEventIndexTempMapper sjzEventIndexTempMapper ;

    @Override
    public int addObject(SjzEventIndexTemp sjzEventIndexTemp) throws PlatformException {
        return sjzEventIndexTempMapper.insert(sjzEventIndexTemp);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzEventIndexTempMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzEventIndexTemp mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzEventIndexTemp getObjectById(int id) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<SjzEventIndexTemp> getPageVoObject(PageVo<SjzEventIndexTemp> pageVo) throws PlatformException {
        List<SjzEventIndexTemp> list = new ArrayList<SjzEventIndexTemp>();

        // step1: 查询当前总记录条数
        int recordCount = sjzEventIndexTempMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzEventIndexTempMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzEventIndexTemp> getAllObject() throws PlatformException {
        return null;
    }
}
