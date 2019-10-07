package com.shijianzhou.language.common.consts;

public enum RelatePatternUnitUseStatusEnuma {

    OPEN((short)0,"开启"),
    OFF((short)10,"关闭");

    private short code;
    private String status;

    RelatePatternUnitUseStatusEnuma(short code, String status) {
        this.code = code;
        this.status = status;
    }

    public short getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

}
