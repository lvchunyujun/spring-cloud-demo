package com.hexiaofei.provider0.service;

import com.hexiaofei.provider0.domain.SjzDomainSpiderTask;
import com.hexiaofei.provider0.domain.SjzDomainWordSort;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;
import org.apache.ibatis.cursor.Cursor;

import java.awt.*;
import java.util.List;

public interface SjzDomainSpiderTaskService extends IBaseService<SjzDomainSpiderTask> {

    List<SjzDomainSpiderTask> getAllObject(Short taskStatus) throws PlatformException;

    Cursor<SjzDomainWordSort> getWordSordDomainCursorByTaskStatus(Short taskStatus)throws PlatformException;

    List<SjzDomainWordSort> getWordSordDomainListByTaskStatus(Short taskStatus)throws PlatformException;

}
