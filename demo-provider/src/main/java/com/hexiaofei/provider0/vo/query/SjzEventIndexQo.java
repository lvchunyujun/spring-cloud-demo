package com.hexiaofei.provider0.vo.query;

import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 事件查询VO
 */
public class SjzEventIndexQo {

    /** 编号 */
    private Integer id;

    /** 开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /** 结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /** 事件状态 */
    private Byte eventState;

    private PageVo pageVo;

    public Byte getEventState() {
        return eventState;
    }

    public void setEventState(Byte eventState) {
        this.eventState = eventState;
    }

    public PageVo getPageVo() {
        return pageVo;
    }

    public void setPageVo(PageVo pageVo) {
        this.pageVo = pageVo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
