package com.lcyj.servicedemo.service.base;


import com.lcyj.common.vo.PageVo;
import com.lcyj.servicedemo.exception.PlatformException;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;
import java.util.Map;


public interface IBaseService<T> {

	int addObject(T mob)throws PlatformException;
	
	int deleteObjectById(int id)throws PlatformException;
	
	int updateObject(T mob)throws PlatformException;
	
	T getObjectById(int id);
	
	PageVo<T> getPageVoObject(PageVo<T> pageVo);

	PageVo<T> getPageVoByObject(PageVo<T> pageVo,T mob);

	PageVo<T> getPageVoByMap(PageVo<T> pageVo,Map<String,Object> map);
	
	List<T> getAllObject();

	Cursor<T> getCursorByObject(T mob);

	Cursor<T> getCursorByMap(Map<String,Object> map);
}
