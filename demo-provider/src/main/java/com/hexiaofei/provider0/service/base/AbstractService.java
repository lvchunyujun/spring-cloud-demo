package com.hexiaofei.provider0.service.base;

public abstract class AbstractService {

    /**
     * 刷新非
     * @param targetObject
     * @param updateObject
     * @param <T>
     * @return
     */
    protected <T> T refreshObjectForNotNullVal(T targetObject,T updateObject){
        Class clazz = targetObject.getClass();

        return null;
    }
}
