package com.hexiaofei.springcloudconsumer.web;

import com.hexiaofei.springcloudconsumer.domain.PageVo;

/**
 * Created by Administrator on 2017/12/26.
 */
public abstract class BaseController {

    class ResultVo{
        private String resultCode;
        private String resultMsg;
        private Object data;

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
    }
}
