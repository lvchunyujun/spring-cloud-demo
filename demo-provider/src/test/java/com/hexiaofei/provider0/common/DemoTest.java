package com.hexiaofei.provider0.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hexiaofei on 2018/4/22.
 */
public class DemoTest {
    static Object o1 = new Object();
    static Object o2 = new Object();

    static SynchronousQueue sq = new SynchronousQueue();
    final CyclicBarrier cyclicBarrier;

    public DemoTest(){
        cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("开始："+Thread.currentThread().getName());
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {

//        BlockingQueue bq = new ArrayBlockingQueue(10);
//
//        for(int i = 0 ; i < 20 ; i++){
//            boolean b = bq.offer(i,1000,TimeUnit.MILLISECONDS);
//            System.out.println(b);
//        }
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(Integer.SIZE - 3);
        System.out.println(-1 << COUNT_BITS);
        System.out.println(0 << COUNT_BITS);
        System.out.println(1 << COUNT_BITS);
        System.out.println(2 << COUNT_BITS);
        System.out.println(3 << COUNT_BITS);
        int RUNNING    = -1 << COUNT_BITS;
        AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        System.out.println(ctl);
//        ExecutorService es = Executors.newFixedThreadPool(10);
    }
    private static int ctlOf(int rs, int wc) { return rs | wc; }
    public void executorF(){
        Executor executor = Executors.newCachedThreadPool();
    }

    public void ff(){
        for(int i = 0 ; i < 10 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("准备："+Thread.currentThread().getName());
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }


    void deadLock(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println(Thread.currentThread()+"--> 1");
                    try {
                        TimeUnit.SECONDS.sleep(9);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        System.out.println(Thread.currentThread()+"--> 2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println(Thread.currentThread()+"--> 1");
                    try {
                        TimeUnit.SECONDS.sleep(9);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        System.out.println(Thread.currentThread()+"--> 2");
                    }
                }
            }
        }).start();
    }

}

