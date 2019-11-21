package com.hexiaofei.common;

import com.hexiaofei.provider0.common.SjzClassLoader;

import java.util.ArrayList;
import java.util.List;

public class TestCommon {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        List<A> list = new ArrayList();

        String file = "com.hexiaofei.common.TestCommon";

        SjzClassLoader sjzClassLoader = new SjzClassLoader();
        SjzClassLoader sjzClassLoader1 = new SjzClassLoader();
        Object a = new A();
        Object a1 = sjzClassLoader.loadClass(file).newInstance();
        Object a2 = sjzClassLoader1.loadClass(file).newInstance();

        System.out.println(a instanceof com.hexiaofei.common.TestCommon);
        System.out.println(a1 instanceof com.hexiaofei.common.TestCommon);
        System.out.println(a2 instanceof com.hexiaofei.common.TestCommon);
    }
}
