package com.hexiaofei.provider0.service.base;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.vo.PageVo;

import java.util.List;


public interface IBaseService<T> {

	int addObject(T mob)throws PlatformException;
	
	int deleteObjectById(int id)throws PlatformException;
	
	int updateObject(T mob)throws PlatformException;
	
	T getObjectById(int id)throws PlatformException;
	
	PageVo<T> getPageVoObject(PageVo<T> pageVo)throws PlatformException;
	
	List<T> getAllObject()throws PlatformException;
}
