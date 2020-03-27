package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.dao.mapper.SjzEventIndexTempMapper;
import com.hexiaofei.sjzclient.domain.SjzEventIndexTemp;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.SjzEventIndexTempService;
import com.hexiaofei.sjzclient.vo.PageVo;
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
    public int updateObject(SjzEventIndexTemp sjzEventIndexTemp) throws PlatformException {
        SjzEventIndexTemp old = getObjectById(sjzEventIndexTemp.getId());

        if(sjzEventIndexTemp.getEventContent()!=null){
            old.setEventContent(sjzEventIndexTemp.getEventContent());
        }
        if(sjzEventIndexTemp.getEventState()!=null){
            old.setEventState(sjzEventIndexTemp.getEventState());
        }
        if(sjzEventIndexTemp.getEventTime()!=null){
            old.setEventTime(sjzEventIndexTemp.getEventTime());
        }
        if(sjzEventIndexTemp.getEventType()!=null){
            old.setEventType(sjzEventIndexTemp.getEventType());
        }

        int resultId = sjzEventIndexTempMapper.updateByPrimaryKey(old);
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
