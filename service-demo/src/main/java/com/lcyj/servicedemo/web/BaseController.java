package com.lcyj.servicedemo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public interface BaseController<T> {

     String index();

     String toAdd();

     String add(T t);

     ModelAndView toUpdate(@PathVariable Integer id);

     ModelAndView update(T t);

     T getObject(@PathVariable Integer id);

     String listEventIndex(T t, @PathVariable int currentPage, @PathVariable int pageSize);

     String delete(Integer id);
}
