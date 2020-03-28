package com.hexiaofei.provider0.common;


public class TestClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       Class cls =  new MyClassLoader().loadClass("java.lang.Object");

    }


}
class MyClassLoader extends ClassLoader{

}