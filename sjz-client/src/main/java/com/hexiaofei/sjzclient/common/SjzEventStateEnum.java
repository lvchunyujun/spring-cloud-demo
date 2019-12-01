package com.hexiaofei.sjzclient.common;

/**
 * 事件审核状态
 */
public enum SjzEventStateEnum {


    RELEASE((short)0,"发布"),
    CHECK((short)10,"待审核"),
    CHECK_SUCCESS((short)20,"审核通过"),
    CHECK_FAIL((short)30,"审核失败");

    private short status;
    private String description;

    SjzEventStateEnum(short status, String description) {
        this.status = status;
        this.description = description;
    }

    public short getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
