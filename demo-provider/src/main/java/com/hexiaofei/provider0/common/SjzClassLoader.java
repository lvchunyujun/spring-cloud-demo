package com.hexiaofei.provider0.common;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SjzClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        try {
            String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
            InputStream is = getClass().getResourceAsStream(fileName);
            if(is == null){
                return super.loadClass(name);
            }
            byte[] bs = new byte[is.available()];
            is.read(bs);
            return defineClass(name,bs,0,bs.length);
        }catch (IOException e) {
            throw new ClassNotFoundException(name);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String file = "com.hexiaofei.provider0.common.SpringContextUtil";


        SjzClassLoader sjzClassLoader = new SjzClassLoader();
        Object a1 = sjzClassLoader.loadClass(file).newInstance();
        Object a2 = sjzClassLoader.loadClass(file).newInstance();

        Class c = new HtmlParser().getClass();
        HtmlParser s = new HtmlParser();

        System.out.println(c.isInstance(s));
//        System.out.println(a2.getClass().isInstance(a1));
    }
}
