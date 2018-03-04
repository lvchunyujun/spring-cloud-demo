package com.hexiaofei.springeurekaclient.domain;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/25.
 */
public class Order {

    private Integer orderId;
    private Integer userId;
    private String orderName;
    private Date createTime;
    private Short status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderName='" + orderName + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
