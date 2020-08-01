package com.lcyj.common.consts;

public enum SpiderTaskStatusEnum {


    /** 开启 */
    ON((short)0,"ON"),
    /** 关闭 */
    OFF((short)10,"OFF");

    private final Short code;
    private final String Status;

    SpiderTaskStatusEnum(Short code, String status) {
        this.code = code;
        Status = status;
    }

    public Short getCode() {
        return code;
    }

    public String getStatus() {
        return Status;
    }
}
