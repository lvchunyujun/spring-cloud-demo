package com.hexiaofei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class TestFF {

    public static void main(String[] args) {

       new Thread(new Runnable() {
           @Override
           public void run() {
               new TestFF().f1();
           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                TestFF.f();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                TestFF.f2();
            }
        }).start();

    }


    public synchronized static void f(){
        System.out.println("f()  "+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void f1(){
        System.out.println("f1()  "+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
