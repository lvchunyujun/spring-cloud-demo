package com.hexiaofei.springeurekaclient.domain;

import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */
public class PageVo {

    private int pageNo ;
    private int pageSize = 10;
    private int pageTotal;
    private List list;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
