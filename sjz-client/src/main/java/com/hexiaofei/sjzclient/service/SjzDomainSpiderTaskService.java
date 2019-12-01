package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.SjzDomainSpiderTask;
import com.hexiaofei.sjzclient.domain.SjzDomainWordSort;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.IBaseService;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

public interface SjzDomainSpiderTaskService extends IBaseService<SjzDomainSpiderTask> {

    List<SjzDomainSpiderTask> getAllObject(Short taskStatus) throws PlatformException;

    Cursor<SjzDomainWordSort> getWordSordDomainCursorByTaskStatus(Short taskStatus)throws PlatformException;

    List<SjzDomainWordSort> getWordSordDomainListByTaskStatus(Short taskStatus)throws PlatformException;

}
