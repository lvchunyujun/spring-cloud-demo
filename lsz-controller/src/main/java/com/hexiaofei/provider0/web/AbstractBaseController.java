package com.hexiaofei.provider0.web;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/12/26.
 */
public abstract class AbstractBaseController<T> {

   protected ResultEntity getResultEntity(){
        return new ResultEntity();
    }

   protected class ResultEntity{
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

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }
}
