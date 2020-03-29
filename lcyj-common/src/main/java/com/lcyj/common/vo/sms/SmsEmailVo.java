package com.lcyj.common.vo.sms;

import com.lcyj.common.vo.PageVo;

public class SmsEmailVo<T> {

    private PageVo<T> pageVo;

    public PageVo<T> getPageVo() {
        return pageVo;
    }

    public void setPageVo(PageVo<T> pageVo) {
        this.pageVo = pageVo;
    }
}
