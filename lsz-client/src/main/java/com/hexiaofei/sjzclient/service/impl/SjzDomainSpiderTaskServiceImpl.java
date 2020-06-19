package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.dao.mapper.SjzDomainSpiderTaskMapper;
import com.hexiaofei.sjzclient.domain.SjzDomainSpiderTask;
import com.hexiaofei.sjzclient.domain.SjzDomainWordSort;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.ISjzDomainSpiderTaskService;
import com.hexiaofei.sjzclient.service.ISjzDomainWordSortService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service("sjzDomainSpiderTaskService")
public class SjzDomainSpiderTaskServiceImpl implements ISjzDomainSpiderTaskService {

    @Autowired
    private SjzDomainSpiderTaskMapper sjzDomainSpiderTaskMapper;

    @Autowired
    private ISjzDomainWordSortService sjzDomainWordSortService;

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
        return sjzDomainSpiderTaskMapper.selectListByAll();
    }


    @Override
    public List<SjzDomainSpiderTask> getAllObject(Short taskStatus) throws PlatformException {
        List<SjzDomainSpiderTask> list = null;
        list = getAllObject();

        list = list.stream().filter(task -> task.getSpiderTaskStatus().equals(taskStatus)).collect(Collectors.toList());

        return list;
    }

    @Override
    public Cursor<SjzDomainWordSort> getWordSordDomainCursorByTaskStatus(Short taskStatus) throws PlatformException {

        List<SjzDomainSpiderTask> list = getAllObject(taskStatus);

        return sjzDomainWordSortService.getCursorByDomainSpiderTaskList(list);
    }

    @Override
    public List<SjzDomainWordSort> getWordSordDomainListByTaskStatus(Short taskStatus) throws PlatformException {
        List<SjzDomainSpiderTask> list = getAllObject(taskStatus);

        return sjzDomainWordSortService.getListByDomainSpiderTaskList(list);
    }


}
