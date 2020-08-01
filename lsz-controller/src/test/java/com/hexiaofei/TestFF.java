package com.hexiaofei;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestFF {

    A a = new A();

    public static void main(String[] args) {

//        B b = new B();
//        ClassLoader cl = b.getClass().getClassLoader();
//        System.out.println(cl.getClass().getName());
//        String s = "";
//        cl =s.getClass().getClassLoader();
//        System.out.println(cl.getClass().getName());
        List<Object> list = new ArrayList<Object>();

        while(true){
            list.add(new B());
        }

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

    public synchronized  void f2() throws CloneNotSupportedException {
        System.out.println("f2()  "+Thread.currentThread().getName());
        TestFF t = new TestFF();
        t.clone();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fun() throws CloneNotSupportedException {
        f2();
        synchronized(a){
            try{
                System.out.println("aa");
            }catch(Exception e){

            }finally {

            }
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
