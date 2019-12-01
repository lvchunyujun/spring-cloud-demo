package com.hexiaofei.sjzclient.service.base;


import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.vo.PageVo;

import java.util.List;


public interface IBaseService<T> {

	int addObject(T mob)throws PlatformException;
	
	int deleteObjectById(int id)throws PlatformException;
	
	int updateObject(T mob)throws PlatformException;
	
	T getObjectById(int id)throws PlatformException;
	
	PageVo<T> getPageVoObject(PageVo<T> pageVo)throws PlatformException;
	
	List<T> getAllObject()throws PlatformException;
}
