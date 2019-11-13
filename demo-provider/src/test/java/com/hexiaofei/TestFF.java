package com.hexiaofei;

import java.util.concurrent.TimeUnit;

public class TestFF {



    public static void main(String[] args) {

        B b = new B();
        ClassLoader cl = b.getClass().getClassLoader();
        System.out.println(cl.getClass().getName());
        String s = "";
        cl =s.getClass().getClassLoader();
        System.out.println(cl.getClass().getName());
    }


    public synchronized static void f(){
        System.out.println("f()  "+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized float f1(){
        System.out.println("f1()  "+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 8;
    }

    public synchronized static void f2(){
        System.out.println("f2()  "+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class A{
    A(){
        System.out.println("A");
    }
    public void f(){}
}

class B extends A{

    B(){
        System.out.println("B");
    }


}
