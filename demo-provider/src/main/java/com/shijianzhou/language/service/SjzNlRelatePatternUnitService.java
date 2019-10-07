package com.shijianzhou.language.service;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnit;
import java.util.List;
import java.util.Map;

public interface SjzNlRelatePatternUnitService extends IBaseService<SjzNlRelatePatternUnit> {

    /**
     * 根据对象查询 : 目前只根据patternName返回列表
     * @param sjzNlRelatePatternUnit
     * @return
     */
    List<SjzNlRelatePatternUnit> getListObject(SjzNlRelatePatternUnit sjzNlRelatePatternUnit)throws PlatformException;

    /**
     * 更新或插入对象：
     *   修改 - ID存在情况
     *   增加 - ID不存在情况
     */
    List<Map<String,Object>> updateOrAddForList(List<SjzNlRelatePatternUnit> list)throws PlatformException;;

    /**
     * 获取关联模板名称、状态列表
     * @return
     * @throws PlatformException
     */
    List<Map<String,Object>> getGroupListByPatternName() throws PlatformException;

    /**
     * 获取关联模板的列表，根据名称
     * @return
     * @throws PlatformException
     */
    List<SjzNlRelatePatternUnit> getListByPatternName() throws PlatformException;
}
