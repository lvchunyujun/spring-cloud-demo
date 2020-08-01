package com.lcyj.common.consts;

/**
 * 系统返回状态码
 */
public enum EnumResultCode {

    SUCCESS("0000","发布"),
    EVENT_DATE_NULL("0100","事件日期不能为空"),
    EVENT_DATE_FORMAT_ERROR("0110","事件日期格式错误"),
    EVENT_CONTENT_NULL("0200","事件内容不能为空"),
    EVENT_CONTENT_MIN_ERROR("0210","事件内容太短"),
    EVENT_CONTENT_MAX_ERROR("0220","事件内容太长"),
    EVENT_DELETE_NOT("1000","事件禁止删除"),
    FAILED("9999","系统错误");

    private String code;
    private String msg;

    EnumResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
