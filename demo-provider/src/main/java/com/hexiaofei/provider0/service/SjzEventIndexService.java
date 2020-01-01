package com.hexiaofei.provider0.service;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.vo.query.SjzEventIndexQo;


public interface SjzEventIndexService extends IBaseService<SjzEventIndex> {

     int addEventIndexAndUser(SjzEventIndex sjzEventIndex, SjzSpiderWebsite sjzSpiderWebsite) throws PlatformException;

     /**
      * 分页查询事件列表
      * @param authorId  作者ID
      * @param sjzEventIndexQo 事件索引
      * @param pageVo 分页
      * @return
      * @throws PlatformException
      */
     PageVo<SjzEventIndex> getPageVoObjectByAuthorId(Integer authorId, SjzEventIndexQo sjzEventIndexQo, PageVo<SjzEventIndex> pageVo)throws PlatformException;
}
