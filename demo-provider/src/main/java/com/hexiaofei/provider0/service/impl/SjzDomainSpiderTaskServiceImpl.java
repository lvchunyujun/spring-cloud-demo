package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzDomainSpiderTaskMapper;
import com.hexiaofei.provider0.domain.SjzDomainSpiderTask;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainSpiderTaskService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("sjzDomainSpiderTaskService")
public class SjzDomainSpiderTaskServiceImpl implements SjzDomainSpiderTaskService {

    @Autowired
    private SjzDomainSpiderTaskMapper sjzDomainSpiderTaskMapper;

    @Override
    public int addObject(SjzDomainSpiderTask mob) throws PlatformException {
        return sjzDomainSpiderTaskMapper.insert(mob);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzDomainSpiderTaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzDomainSpiderTask mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzDomainSpiderTask getObjectById(int id) throws PlatformException {
        return sjzDomainSpiderTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<SjzDomainSpiderTask> getPageVoObject(PageVo<SjzDomainSpiderTask> pageVo) throws PlatformException {
        List<SjzDomainSpiderTask> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzDomainSpiderTaskMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzDomainSpiderTaskMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzDomainSpiderTask> getAllObject() throws PlatformException {
        return null;
    }
}
