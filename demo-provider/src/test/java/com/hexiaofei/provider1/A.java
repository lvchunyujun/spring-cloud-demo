package com.hexiaofei.provider1;



import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class A {

    public static void main(String[] args) {
        short s = 1;
//        s = s + 1;
//
        System.out.println(s += 1);
    }

//    public void method() {
//        synchronized (this) {
//            System.out.println("synchronized 代码块");
//        }
//    }

    public synchronized void method() {
        System.out.println("synchronized 方法");
    }
}
