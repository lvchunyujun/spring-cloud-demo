package com.hexiaofei.sjzclient.common;

/**
 * 事件类型
 */
public enum EnumEventType {

    TEXT((byte)0,"文本"),
    LINK((byte)10,"超链接");

    private byte type;
    private String desc;

    EnumEventType(byte type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public byte getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

}
