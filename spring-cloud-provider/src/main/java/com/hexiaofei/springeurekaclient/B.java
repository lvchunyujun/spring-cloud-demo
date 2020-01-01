package com.hexiaofei.springclient;


/**
 * Created by hexiaofei on 2018/4/6.
 */
public class B {

    public static String code = "hello!";
    static{
        int i = 10;
    }
    public String name = "B";

    public A a;

    public void setA(Object a){
        this.a = (A)a;
    }

    public void f2(){
        a = new A();
        System.out.println(name);
        System.out.println(a.f1());
    }



}
