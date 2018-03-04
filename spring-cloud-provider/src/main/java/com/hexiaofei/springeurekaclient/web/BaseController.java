package com.hexiaofei.springeurekaclient.web;

import com.hexiaofei.springeurekaclient.domain.Order;
import com.hexiaofei.springeurekaclient.domain.OrderVo;
import com.hexiaofei.springeurekaclient.domain.PageVo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */
public abstract class BaseController {

    ResultVo getResultVo(){
        return new ResultVo();
    }

    class ResultVo{
        private String resultCode;
        private String resultMsg;
        private PageVo pageVo;
        private Object object;

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

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }

    PageVo convertPageVo(PageVo pageVo){
        List<Order> list = pageVo.getList();
        List<OrderVo> listVo = new ArrayList<>();
        for(Order order: list){
            OrderVo orderVo = new OrderVo();
            orderVo.setOrderId(order.getOrderId());
            orderVo.setUserId(order.getUserId());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            orderVo.setCreateTime(simpleDateFormat.format(order.getCreateTime()));
            orderVo.setOrderName(order.getOrderName());
            listVo.add(orderVo);
        }
        pageVo.setList(listVo);
        return pageVo;
    }
}
