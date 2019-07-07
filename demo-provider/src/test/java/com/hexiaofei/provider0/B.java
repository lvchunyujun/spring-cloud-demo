package com.hexiaofei.provider0;

import com.hexiaofei.provider1.A;
import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by hexiaofei on 2018/4/22.
 */
public class B<K,V> extends A {

     volatile static int i = 1;
    final static B b = new B();

    public static void main(String[] args) throws InterruptedException {


//        HashMap map = new HashMap<>();
//        int i = 100000;
//
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(22);
//        arrayList.remove(null);
//
//        LinkedList li = new LinkedList();
//        li.add(null);
//        li.remove();
//
//        CopyOnWriteArrayList cowa = new CopyOnWriteArrayList();
//        cowa.add(null);
//        cowa.remove(null);
//        Stack stack;


//        LinkedHashMap<String,String> hm = new LinkedHashMap<>();
//        hm.put("a","aa");
//        hm.put("b","bb");
//        hm.put("c","cc");
//
//        Iterator<String> keys = hm.keySet().iterator();
//        while(keys.hasNext()){
//            System.out.println(hm.get(keys.next()));
//        }
//        hm.get("");
//        for(int i = 0 ; i < 100 ; i++){
//            System.out.println(i+"  "+Integer.highestOneBit(i));
//        }
//        ArrayBlockingQueue abq = new ArrayBlockingQueue<String>(200);
//        try {
//            abq.put("");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        HashMap map = new HashMap();
//        map.put(null,null);

        // ！ 不允许有 null 的 key or value ，否则报 NullPointerException;
//        Hashtable ht = new Hashtable();
//        ht.put(null,"");
//        ht.get("");

//        TreeMap tm = new TreeMap();
//        tm.put(null,null);

//        HashSet hs = new HashSet(new HashSet());
//        System.out.println(hs.add("key"));
//        System.out.println(hs.add("zhang"));
//
//        LinkedHashSet lhs = new LinkedHashSet();
//        lhs.add(null);
//
//        ConcurrentHashMap cm = new ConcurrentHashMap();
//        cm.put("","");
//
//        System.out.println(1<<2);
//
//
//        int sshift = 0;
//        int ssize = 1;
        /**
         *   concurr sshift ssize
         0  0  1
         1  0  1
         2  1  2
         3  2  4
         4  2  4
         5  3  8
         6  3  8
         7  3  8
         8  3  8
         9  4  16
         *
         */

//        for(int concurrencyLevel = 0 ; concurrencyLevel < 1025 ; concurrencyLevel++){
//            while (ssize < concurrencyLevel) {
//                ++sshift;
//                ssize <<= 1;
//            }
//            System.out.println(concurrencyLevel+"  "+sshift+"  "+ssize);
//        }
//         int MAXIMUM_CAPACITY = 1 << 30;
//         int number = 0;
//        for(int i = 0 ; i < 100 ; i++){
//            number = i;
//            number = number >= MAXIMUM_CAPACITY
//                    ? MAXIMUM_CAPACITY
//                    : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
//            System.out.println(i+"  "+number);
//        }

//         for(int i = 0 ; i < 9999999 ; i++){
//             int j = 0;
//             map.put(j = new Random().nextInt(9999999),i);
//             System.out.println(j);
//         }
//
//        System.out.println(map);
//         ArrayBlockingQueue<Integer> iq = new ArrayBlockingQueue<>(30);
//        ExecutorService es = Executors.newFixedThreadPool(3);
//        es.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while(true){
//                      iq.put(i++);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        ExecutorService es1 = Executors.newFixedThreadPool(3);
//        es1.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    f1();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        es1.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    b.f1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        String name = "";
        AtomicStampedReference asr = new AtomicStampedReference(name,1);
    }


    public void f1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": 我获取了锁！");
        System.out.println(Thread.currentThread().getName() + ": 进入睡眠！");
        this.wait(3000);
        System.out.println(Thread.currentThread().getName()+": 苏醒！");
    }


}
