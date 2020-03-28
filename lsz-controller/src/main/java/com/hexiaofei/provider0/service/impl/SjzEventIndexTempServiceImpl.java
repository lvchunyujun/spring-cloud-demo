package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.common.consts.SjzEventStateEnum;
import com.hexiaofei.provider0.dao.mapper.SjzEventIndexTempMapper;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.domain.SjzEventIndexTemp;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.service.SjzEventIndexTempService;
import com.hexiaofei.provider0.service.base.AbstractService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("sjzEventIndexTemp")
public class SjzEventIndexTempServiceImpl extends AbstractService implements SjzEventIndexTempService {

    @Autowired
    private SjzEventIndexTempMapper sjzEventIndexTempMapper ;

    @Autowired
    private SjzEventIndexService sjzEventIndexService;

    @Override
    public int addObject(SjzEventIndexTemp sjzEventIndexTemp) throws PlatformException {
        return sjzEventIndexTempMapper.insert(sjzEventIndexTemp);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzEventIndexTempMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzEventIndexTemp sjzEventIndexTemp) throws PlatformException {
        SjzEventIndexTemp targetObj = getObjectById(sjzEventIndexTemp.getId());
        // step1: 更新对象
        targetObj = refreshObjectForNotNullVal(targetObj,sjzEventIndexTemp);

        int resultId = sjzEventIndexTempMapper.updateByPrimaryKey(targetObj);

        // step2: 判断审核状态:审核通过需要增加一条事件记录。
        byte state = targetObj.getEventState();
        if(SjzEventStateEnum.CHECK_SUCCESS.getStatus() == state){
            SjzEventIndex sjzEventIndex = new SjzEventIndex();
            sjzEventIndex.setEventType(targetObj.getEventType());
            sjzEventIndex.setEventTime(targetObj.getEventTime());
            sjzEventIndex.setEventContent(targetObj.getEventContent());
            sjzEventIndex.setRecordCreateTime(targetObj.getCreateTime());
            sjzEventIndex.setEventState(state);
            sjzEventIndexService.addObject(sjzEventIndex);
        }
        return resultId;
    }

    @Override
    public SjzEventIndexTemp getObjectById(int id) throws PlatformException {
        return sjzEventIndexTempMapper.selectByPrimaryKey(id);
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
