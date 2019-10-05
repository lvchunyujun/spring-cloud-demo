package com.shijianzhou.language.service.impl;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.AbstractService;
import com.hexiaofei.provider0.service.base.BaseService;
import com.hexiaofei.provider0.vo.PageVo;
import com.shijianzhou.language.dao.mapper.SjzNlRelatePatternUnitMapper;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnit;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnitExample;
import com.shijianzhou.language.service.SjzNlRelatePatternUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("sjzNlRelatePatternUnitService")
public class SjzNlRelatePatternUnitServiceImpl extends AbstractService implements SjzNlRelatePatternUnitService {

    @Autowired
    private SjzNlRelatePatternUnitMapper sjzNlRelatePatternUnitMapper;

    @Override
    public int addObject(SjzNlRelatePatternUnit sjzNlRelatePatternUnit) throws PlatformException {
        return sjzNlRelatePatternUnitMapper.insert(sjzNlRelatePatternUnit);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzNlRelatePatternUnitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzNlRelatePatternUnit mob) throws PlatformException {
        SjzNlRelatePatternUnit targetObj = sjzNlRelatePatternUnitMapper.selectByPrimaryKey(mob.getId());
        targetObj = refreshObjectForNotNullVal(targetObj,mob);
        return sjzNlRelatePatternUnitMapper.updateByPrimaryKey(targetObj);
    }

    @Override
    public SjzNlRelatePatternUnit getObjectById(int id) throws PlatformException {
        return sjzNlRelatePatternUnitMapper.selectByPrimaryKey(id);
    }




    @Override
    public PageVo<SjzNlRelatePatternUnit> getPageVoObject(PageVo<SjzNlRelatePatternUnit> pageVo) throws PlatformException {
        List<SjzNlRelatePatternUnit> list = new ArrayList<SjzNlRelatePatternUnit>();

        // step1: 查询当前总记录条数
        int recordCount = sjzNlRelatePatternUnitMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzNlRelatePatternUnitMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzNlRelatePatternUnit> getAllObject() throws PlatformException {
        return null;
    }


    @Override
    public List<SjzNlRelatePatternUnit> getListObject(SjzNlRelatePatternUnit sjzNlRelatePatternUnit) {

        SjzNlRelatePatternUnitExample rpue = new SjzNlRelatePatternUnitExample();
        SjzNlRelatePatternUnitExample.Criteria criteria = rpue.createCriteria();
        rpue.setOrderByClause(" unitSerialNo asc ");
        criteria.andPatternNameEqualTo(sjzNlRelatePatternUnit.getPatternName());

        return sjzNlRelatePatternUnitMapper.selectByExample(rpue);
    }

    @Override
    public List<Map<String, Object>> updateOrAddForList(List<SjzNlRelatePatternUnit> list) throws PlatformException {
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (SjzNlRelatePatternUnit obj: list){
            Map<String,Object> map = new HashMap<>();
            int resultId = -1;
            map.put("obj",obj);

            if(obj.getId() == null){                // step1:  id存在则修改对象
                obj.setCreateTime(new Date());
                resultId = addObject(obj);
            }else {                                 // step2:  id不存在则添加对象
                resultId = updateObject(obj);
            }
            // step3:  设置结果
            map.put("resultId",resultId);
        }
        return resultList;
    }
}
