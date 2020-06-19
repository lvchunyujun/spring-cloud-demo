package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.SjzDomainSpiderTask;
import com.hexiaofei.sjzclient.domain.SjzDomainWordSort;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.IBaseService;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

public interface ISjzDomainWordSortService extends IBaseService<SjzDomainWordSort> {

    Cursor<SjzDomainWordSort> getCursorByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) throws PlatformException;
    List<SjzDomainWordSort> getListByDomainSpiderTaskList(List<SjzDomainSpiderTask> list) throws PlatformException;
}
