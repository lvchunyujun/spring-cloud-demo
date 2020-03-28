package com.shijianzhou.language.common.consts;

/**
 * 元数据单词据常量
 */
public interface NlWordMetaConsts {

    /** 初始元数据词类的父类编码 */
    int ORIGINAL_WORD_META_CODE = 0;
    /** 一级单词初始编码 */
    int FIRST_LEVEL_START_WORD_META_CODE = 100000;
    /**
     *  <p>
     *  级别范围:
     *  所含单词数量 = LEVEL_RANGE*LEVEL_COUNT
     *          10 = 1 * 10；
     *  <p>
     */
    int LEVEL_RANGE = 1;
    /** 数量级 */
    int LEVEL_COUNT = 10;
}
