package com.hexiaofei.provider0.service.base;

import com.hexiaofei.provider0.exception.ArgumentsConvertPlatformException;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractService {

    /**
     * 刷新对象值-根据updateObject非空的字段替换掉targetObject对象的值
     * 注意：不支持集成来的字段
     * @param targetObject
     * @param updateObject
     * @param <R>
     * @return
     */
    protected <R> R refreshObjectForNotNullVal(R targetObject,R updateObject) throws ArgumentsConvertPlatformException{
        Class clazz = targetObject.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for(int i = 0 ; i < fields.length ; i++ ){

            String fieldName = fields[i].getName();
            try {
                PropertyDescriptor prop = new PropertyDescriptor(fieldName, clazz);
                // 获取getter方法，反射获取id值
                Object objVal = prop.getReadMethod().invoke(updateObject);
                if(objVal != null){
                    prop.getWriteMethod().invoke(targetObject,objVal);
                }
            } catch (IllegalAccessException e) {
                throw new ArgumentsConvertPlatformException();
            } catch (IntrospectionException e) {
                throw new ArgumentsConvertPlatformException();
            } catch (InvocationTargetException e) {
                throw new ArgumentsConvertPlatformException();
            }
        }

        return targetObject;
    }
}
