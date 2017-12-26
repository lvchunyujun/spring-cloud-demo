package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.domain.PageVo;

/**
 * Created by Administrator on 2017/12/26.
 */
public abstract class BaseController {

    class ResultVo{
        private String resultCode;
        private String resultMsg;
        private PageVo pageVo;

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

        public PageVo getPageVo() {
            return pageVo;
        }

        public void setPageVo(PageVo pageVo) {
            this.pageVo = pageVo;
        }
    }
}
