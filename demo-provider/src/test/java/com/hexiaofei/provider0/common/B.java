package com.hexiaofei.provider0.common;

import com.hexiaofei.provider1.A;
import java.util.concurrent.*;
/**
 * Created by hexiaofei on 2018/4/22.
 */
public class B<K,V> {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    /** 线程池容量 (2^29)-1 */
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    /** 接受新任务并且继续处理阻塞队列中的任务 */
    private static final int RUNNING    = -1 << COUNT_BITS;
    /** 不接受新任务但是会继续处理阻塞队列中的任务 */
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    /** 不接受新任务，不在执行阻塞队列中的任务，中断正在执行的任务 */
    private static final int STOP       =  1 << COUNT_BITS;
    /** 所有任务都已经完成，线程数都被回收，线程会转到TIDYING状态会继续执行钩子方法 */
    private static final int TIDYING    =  2 << COUNT_BITS;
    /** 终止： 钩子方法执行完毕 */
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args)  {


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
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" ");
                    TimeUnit.SECONDS.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        ExecutorService es1 = Executors.newFixedThreadPool(3);
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
//        es1.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    b.f1();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        String name = "";
//        AtomicStampedReference asr = new AtomicStampedReference(name,1);
//        AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
//        System.out.println(Integer.SIZE);
//        System.out.println(CAPACITY);
//        System.out.println(-1<<COUNT_BITS);
//        System.out.println(0<<COUNT_BITS);
//        System.out.println(1<<COUNT_BITS);
//        System.out.println(2<<COUNT_BITS);
//        System.out.println(3<<COUNT_BITS);
//        System.out.println(ctl.get());


//        System.out.println("end！");
    }


    public void f1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": 我获取了锁！");
        System.out.println(Thread.currentThread().getName() + ": 进入睡眠！");
        this.wait(3000);
        System.out.println(Thread.currentThread().getName()+": 苏醒！");
    }


    private static int ctlOf(int rs, int wc) { return rs | wc; }
}
