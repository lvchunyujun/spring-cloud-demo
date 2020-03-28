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

    /**
     * 查询单词信息根据wordMetaCode
     * @param wordMetaCode
     * @return
     * @throws PlatformException
     */
    SjzNlWordMeta getSjzNlWordMetaByWordMetaCode(Integer wordMetaCode)throws PlatformException;

    /**
     * 查询父类单词根据给定单词编码
     * @return wordMetaCode
     * @throws PlatformException
     */
    SjzNlWordMeta getParentWordMetaByWordMetaCode(Integer wordMetaCode)throws PlatformException;

    /**
     * 查询下一级词类列表根据给定单词编码
     * @param wordMetaCode
     * @return
     * @throws PlatformException
     */
    List<SjzNlWordMeta> getNextListWordMetaByWordMetaCode(Integer wordMetaCode)throws PlatformException;

    /**
     * 获取同级中最小编码的单词
     * @param wordMetaCode
     * @return
     * @throws PlatformException
     */
    int getMinSameLevelWordMetaCodeByParentWordMetaCode(Integer wordMetaCode)throws PlatformException;

    /**
     * 获取同级中最大编码的单词
     * @param wordMetaCode
     * @return
     * @throws PlatformException
     */
    int getMaxSameLevelWordMetaCodeByParentWordMetaCode(Integer wordMetaCode)throws PlatformException;
}
