package com.hexiaofei.provider0.common.consts;

/**
 * 历史轴系统参数配置
 */
public interface LszSystemConsts {


    String CONSUME_SOURCE_MAP_URL = "URL";
    String CONSUME_SOURCE_MAP_TXT = "TXT";

    String DATE_FORMAT_1 = "yyyy-MM-dd";
    String DATE_FORMAT_2 = "yyyy年MM月dd";
    String DATE_FORMAT_3 = "yyyy/MM/dd";
    String DATE_FORMAT_4 = "yyyy.MM.dd";

    /** 事件类型：文本 */
    Byte EVENT_TYPE_TXT = 0;
    /** 事件类型：超链接 */
    Byte EVENT_TYPE_LINK = 10;
    /** 事件类型：图片 */
    Byte EVENT_TYPE_IMG = 20;

    /** 0:正常 默认 */
     Byte EVENT_STATE_SHOW = 0;
    /** 10:不显示 */
    Byte EVENT_STATE_NO_SHOW = 10;

    /** 事件内容最大长度*/
    int EVENT_CONTENT_MAX_LENGTH = 500;
}
