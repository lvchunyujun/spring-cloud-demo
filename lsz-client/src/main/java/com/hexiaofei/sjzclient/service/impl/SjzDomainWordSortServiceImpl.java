package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.dao.mapper.SjzDomainWordSortMapper;
import com.hexiaofei.sjzclient.domain.SjzDomainSpiderTask;
import com.hexiaofei.sjzclient.domain.SjzDomainWordSort;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.SjzDomainSpiderTaskService;
import com.hexiaofei.sjzclient.service.SjzDomainWordSortService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("sjzDomainWordSortService")
public class SjzDomainWordSortServiceImpl implements SjzDomainWordSortService {

    @Autowired
    private SjzDomainWordSortMapper sjzDomainWordSortMapper;

    @Autowired
    private SjzDomainSpiderTaskService sjzDomainSpiderTaskService;

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


    @Override
    public Cursor<SjzDomainWordSort> getCursorByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) throws PlatformException {

        Map<String,List<SjzDomainSpiderTask>> map = new HashMap<>();
        map.put("list",list);

        return sjzDomainWordSortMapper.selectCursorBySpiderTaskList(map);
    }

    @Override
    public List<SjzDomainWordSort> getListByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) throws PlatformException {
        Map<String,List<SjzDomainSpiderTask>> map = new HashMap<>();
        map.put("list",list);

        return sjzDomainWordSortMapper.selectListBySpiderTaskList(map);
    }
}
