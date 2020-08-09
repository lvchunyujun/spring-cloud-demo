package com.hexiaofei.sjzclient.web;

import com.lcyj.common.vo.ResultVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface BaseController<T> {

     String index();

     String toAdd();

     String add(T t);

     ResultVo<T> add(HttpServletRequest request,T t);

     ModelAndView toUpdate(@PathVariable Integer id);

     ModelAndView update(T t);

     String listEventIndex(T t, @PathVariable int currentPage, @PathVariable int pageSize);

     String delete(Integer id);

     default ResultVo<T> deleteById(Integer id){
          return new ResultVo<T>();
     }
}
