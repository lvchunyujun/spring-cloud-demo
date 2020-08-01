package com.lcyj.common.vo;

import com.alibaba.fastjson.JSONObject;

public class ResultVo<T> {

    private String resultCode;
    private String resultMsg;
    private Object data;

    public ResultVo() {
    }

    public ResultVo(String resultCode) {
        this.resultCode = resultCode;
    }

    public ResultVo(String resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
