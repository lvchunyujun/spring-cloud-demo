package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzDomainWordSortMapper;
import com.hexiaofei.provider0.domain.SjzDomainWordSort;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainWordSortService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("sjzDomainWordSortService")
public class SjzDomainWordSortServiceImpl implements SjzDomainWordSortService {

    @Autowired
    private SjzDomainWordSortMapper sjzDomainWordSortMapper;

    @Override
    public int addObject(SjzDomainWordSort mob) throws PlatformException {
        return sjzDomainWordSortMapper.insert(mob);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzDomainWordSortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzDomainWordSort mob) throws PlatformException {
        return -1;
    }

    @Override
    public SjzDomainWordSort getObjectById(int id) throws PlatformException {
        return sjzDomainWordSortMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<SjzDomainWordSort> getPageVoObject(PageVo<SjzDomainWordSort> pageVo) throws PlatformException {
        List<SjzDomainWordSort> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzDomainWordSortMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzDomainWordSortMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzDomainWordSort> getAllObject() throws PlatformException {
        return null;
    }
}
