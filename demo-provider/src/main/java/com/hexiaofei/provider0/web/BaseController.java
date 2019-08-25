package com.hexiaofei.provider0.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public interface BaseController<T> {

     String index();

     String toAdd();

     String add(T t);

     ModelAndView toUpadte(@PathVariable Integer id);

     ModelAndView update(T t);

     String listEventIndex(T t,@PathVariable int currentPage,@PathVariable int pageSize);
}
