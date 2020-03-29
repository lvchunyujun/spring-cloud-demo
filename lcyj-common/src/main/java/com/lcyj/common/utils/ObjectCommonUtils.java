package com.lcyj.common.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 对象工具类
 */
public class ObjectCommonUtils {

    /**
     * 刷新对象值-根据updateObject非空的字段替换掉targetObject对象的值
     * 注意：不支持集成来的字段
     * @param targetObject 目标对象
     * @param updateObject 更新对象
     * @param <R>
     * @return
     */
    public static <R> R refreshObjectForNotNullVal(R targetObject,R updateObject) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class clazz = targetObject.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for(int i = 0 ; i < fields.length ; i++ ){
            String fieldName = fields[i].getName();
                PropertyDescriptor prop = new PropertyDescriptor(fieldName, clazz);
                // 获取getter方法，反射获取id值
                Object objVal = prop.getReadMethod().invoke(updateObject);
                if(objVal != null){
                    prop.getWriteMethod().invoke(targetObject,objVal);
                }
        }
        return targetObject;
    }
}
