package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzEventIndexMapper;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.IUserInfoService;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import com.hexiaofei.provider0.vo.PageVo;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("sjzEventIndexService")
public class SjzEventIndexServiceImpl implements SjzEventIndexService {

    @Autowired
    private SjzEventIndexMapper sjzEventIndexMapper;

    @Autowired
    private SjzSpiderWebsiteService sjzSpiderWebsiteService;

    @Transactional(rollbackFor = Exception.class) 
    @Override
    public int addEventIndexAndUser(SjzEventIndex sjzEventIndex, SjzSpiderWebsite sjzSpiderWebsite) throws PlatformException {

        sjzSpiderWebsiteService.addObject(sjzSpiderWebsite);

        addObject(sjzEventIndex);
        if(true)
         throw new PlatformException("测试事物传播");
        return 0;
    }



    @Override
    public int addObject(SjzEventIndex mob) throws PlatformException {
        int resultId = -1;
        if(mob!=null){
            resultId = sjzEventIndexMapper.insert(mob);
//            throw new PlatformException("测试事物传播");
        }
        return resultId;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzEventIndexMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzEventIndex sjzEventIndex) throws PlatformException {

        SjzEventIndex old = getObjectById(sjzEventIndex.getId());

        if(sjzEventIndex.getEventContent()!=null){
            old.setEventContent(sjzEventIndex.getEventContent());
        }
        if(sjzEventIndex.getEventState()!=null){
            old.setEventState(sjzEventIndex.getEventState());
        }
        if(sjzEventIndex.getEventTime()!=null){
            old.setEventTime(sjzEventIndex.getEventTime());
        }
        if(sjzEventIndex.getEventType()!=null){
            old.setEventType(sjzEventIndex.getEventType());
        }

        int resultId = sjzEventIndexMapper.updateByPrimaryKey(old);
        return 0;
    }

    @Override
    public SjzEventIndex getObjectById(int id) throws PlatformException {
        return sjzEventIndexMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<SjzEventIndex> getPageVoObject(PageVo<SjzEventIndex> pageVo) throws PlatformException {

        List<SjzEventIndex> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzEventIndexMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzEventIndexMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzEventIndex> getAllObject() throws PlatformException {
        return null;
    }


}
