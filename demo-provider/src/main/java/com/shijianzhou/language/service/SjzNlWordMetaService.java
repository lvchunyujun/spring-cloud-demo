package com.shijianzhou.language.service;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;
import com.shijianzhou.language.domain.SjzNlWordMeta;

import java.util.List;

public interface SjzNlWordMetaService extends IBaseService<SjzNlWordMeta> {

    /**
     * 正则表达式匹配匹配检查
     * @param sjzNlWordMeta
     * @return
     * @throws PlatformException
     */
    boolean getNlRegExpCheck(SjzNlWordMeta sjzNlWordMeta) throws PlatformException;

    /**
     *
     * @param sjzNlWordMeta
     * @return
     * @throws PlatformException
     */
    SjzNlWordMeta getObjectForRegExp(SjzNlWordMeta sjzNlWordMeta)throws PlatformException;

    /**
     * 返回匹配结果给定表达式代码
     * @param targetStr
     * @param regExpCode
     * @return
     * @throws PlatformException
     */
    boolean getMarchResultForRegExpCode(String targetStr, String regExpCode)throws PlatformException;

    /**
     * 返回List给定正则表达式代码
     * @param targetStr
     * @param regExpCode
     * @return
     * @throws PlatformException
     */
    List<String> getListMarchForRegExpCode(String targetStr, String regExpCode)throws PlatformException;
}
