package com.lcyj.servicedemo.service.base;

import com.lcyj.common.utils.ObjectCommonUtils;
import com.lcyj.servicedemo.exception.ArgumentsConvertPlatformException;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractService {


    protected <R> R refreshObjectForNotNullVal(R targetObject,R updateObject) throws ArgumentsConvertPlatformException {
        try {
            targetObject = ObjectCommonUtils.refreshObjectForNotNullVal(targetObject,updateObject);
        } catch (IntrospectionException e) {
            throw new ArgumentsConvertPlatformException();
        } catch (InvocationTargetException e) {
            throw new ArgumentsConvertPlatformException();
        } catch (IllegalAccessException e) {
            throw new ArgumentsConvertPlatformException();
        }
        return targetObject;
    }
}
