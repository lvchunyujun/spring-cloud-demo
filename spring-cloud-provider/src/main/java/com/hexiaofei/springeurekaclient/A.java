package com.hexiaofei.springclient;


/**
 * Created by hexiaofei on 2018/4/6.
 */
public class A{


    private String name = "A";

    public A() {
        System.out.println("This is A init{} !");
    }

    public String f1(){
        System.out.println(name);
        return name;
    }

}
