package com.hexiaofei.springcloudconsumer.service;

import com.hexiaofei.springcloudconsumer.domain.PageVo;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/13.
 */
public interface IBaseService<T> {

    int addObject(T t);

    int deleteObjectById(Integer id);

    int updateObjectById(Integer id);

    T getObjectById(Integer id);

    PageVo getListByPageVo(PageVo pageVo, Map<String, Object> paraMap);
}
