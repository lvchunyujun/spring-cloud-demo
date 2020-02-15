package com.hexiaofei.provider0.common.consts;

/**
 * 事件审核状态
 */
public enum SjzEventStateEnum {

    /** 事件审核状态：0-发布 */
    RELEASE((byte)0,"发布"),
    /** 事件审核状态：10-待审核 */
    CHECK((byte)10,"待审核"),
    /** 事件审核状态：20-审核通过 */
    CHECK_SUCCESS((byte)20,"审核通过"),
    /** 事件审核状态：30-审核失败 */
    CHECK_FAIL((byte)30,"审核失败");

    private byte status;
    private String description;

    SjzEventStateEnum(byte status, String description) {
        this.status = status;
        this.description = description;
    }

    public byte getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
