package com.hexiaofei.provider0.service;

import com.hexiaofei.provider0.domain.SjzDomainSpiderTask;
import com.hexiaofei.provider0.domain.SjzDomainWordSort;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

public interface SjzDomainWordSortService extends IBaseService<SjzDomainWordSort> {

    Cursor<SjzDomainWordSort> getCursorByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) throws PlatformException;
    List<SjzDomainWordSort> getListByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) throws PlatformException;
}
