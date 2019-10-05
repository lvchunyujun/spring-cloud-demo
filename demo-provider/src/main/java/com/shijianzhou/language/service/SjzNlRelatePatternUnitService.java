package com.shijianzhou.language.service;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnit;
import java.util.List;
import java.util.Map;

public interface SjzNlRelatePatternUnitService extends IBaseService<SjzNlRelatePatternUnit> {

    /**
     * 根据对象查询
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
}
