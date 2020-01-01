package com.sjz.common.consts;

public interface SjzSystemConsts {


    String CONSUME_SOURCE_MAP_URL = "URL";
    String CONSUME_SOURCE_MAP_TXT = "TXT";

    String DATE_FORMAT_1 = "yyyy-MM-dd";
    String DATE_FORMAT_2 = "yyyy年MM月dd";
    String DATE_FORMAT_3 = "yyyy/MM/dd";
    String DATE_FORMAT_4 = "yyyy.MM.dd";

    Byte EVENT_TYPE_TXT = 0;
    Byte EVENT_TYPE_LINK = 10;
    Byte EVENT_TYPE_IMG = 20;

    /** 0:正常 默认 */
     Byte EVENT_STATE_SHOW = 0;
    /** 10:不显示 */
    Byte EVENT_STATE_NO_SHOW = 10;
}
