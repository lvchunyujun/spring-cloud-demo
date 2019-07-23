package com.hexiaofei.provider1;



import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class A {


    protected void fF() {
        List l = new ArrayList<Object>();
             l.remove(3);
             l = new LinkedList();
             ((LinkedList) l).remove(3);
             l = new CopyOnWriteArrayList();

        String s1 = "", s2 = "";
        s1.concat(s2);
        l.size();

        StringBuffer sbuf = null;
        sbuf.append("");
        StringBuilder sbl = null;
        sbl.append("Str");
        for (int i = 0; i < l.size(); i++) {

        }

        List<String> l1 = new LinkedList();
        for (String s : l1) {

        }
    }

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination, InterruptedException {
//        char[] cc = "律陆驴流遛鎏鲁率驴".toCharArray();
//        for(char cn: cc){
//            String[] ss = PinyinHelper.toHanyuPinyinStringArray(cn,new HanyuPinyinOutputFormat());
//            if(ss!=null){
//                for(int i = 0 ; i <  ss.length ; i++)
//                    System.out.print(ss[i]);
//                System.out.println();
//            }
//
//        }

//        for (int i = 0; i < Character.MAX_VALUE; i++) {
////
////            if (i == 40869) {
////                System.out.println();
////                System.out.print((char) i + "   ");
////                break;
////            }
////        }
////
////        System.out.println((char) Integer.parseInt("9FA5", 16));
////
////        String name = "sunday";
////        int ordinal = 0;
////        Enum week = new Enum(name,ordinal) {
////
////            String week;
////            int ordinal;
////
////
////            @Override
////            public int compareTo(Object o) {
////                return 0;
////            }
////        };
//        Vector<String> vector = new Vector(10);
//        vector.add("张三");
//        vector.add("李四");
//        vector.forEach(str -> {
//            if("张三".equals(str)){
//                System.out.println("我找到了！");
//            }
//        });
//        Hashtable<String,String> ht = null ;
//        ht.put(null,null);
//        HashMap<String,String> map = null;
//        map.put(null,null);
//
//        BlockingQueue b;
//        TreeMap treeMap;

        List<Integer> cowa = new CopyOnWriteArrayList();

        for(int i = 0 ; i < 10 ; i++){
            cowa.add(i);
        }

        for(Integer i: cowa){
            cowa.add(i);
        }
        int j = 10;
        Iterator iterable = cowa.iterator();
        while(iterable.hasNext()){
            cowa.add(j++);
            cowa.remove(3);
            System.out.println(iterable.next());
            iterable.remove();
        }

        Collections.synchronizedMap(new HashMap<>());
    }

}
