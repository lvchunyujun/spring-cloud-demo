package com.hexiaofei.provider0;

import com.hexiaofei.provider1.A;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hexiaofei on 2018/4/22.
 */
public class B extends A {

    volatile String s;

    public static void main(String[] args){


        HashMap map = new HashMap<>();
        int i = 100000;

        ArrayList arrayList = new ArrayList();
        arrayList.add(22);

        LinkedList li = new LinkedList();
        li.add(null);

        CopyOnWriteArrayList cowa = new CopyOnWriteArrayList();
        cowa.add(null);
        cowa.remove(null);
        Stack stack;

//        for(int i = 0 ; i < 100 ; i++){
//            System.out.println(i+"  "+Integer.highestOneBit(i));
//        }
    }
}
