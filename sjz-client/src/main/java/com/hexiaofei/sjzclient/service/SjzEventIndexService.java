package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.SjzEventIndex;
import com.hexiaofei.sjzclient.domain.SjzSpiderWebsite;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.IBaseService;
import com.hexiaofei.sjzclient.vo.PageVo;


public interface SjzEventIndexService extends IBaseService<SjzEventIndex> {

     int addEventIndexAndUser(SjzEventIndex sjzEventIndex, SjzSpiderWebsite sjzSpiderWebsite) throws PlatformException;

     PageVo<SjzEventIndex> getPageVoObjectBySjzEventIndex(SjzEventIndex eventIndex, PageVo<SjzEventIndex> pageVo)throws PlatformException;
}
