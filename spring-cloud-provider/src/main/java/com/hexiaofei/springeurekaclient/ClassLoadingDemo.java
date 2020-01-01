package com.hexiaofei.springclient;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

/**
 * Created by hexiaofei on 2018/4/6.
 */
public class ClassLoadingDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        MyClassLoader myClassLoader = new MyClassLoader();
//        ClassLoader classLoader = new ClassLoader(){};
//        Class<A> c = (Class)myClassLoader.loadClass("com.hexiaofei.springclient.A");
//        Class c1 = (Class)classLoader.loadClass("com.hexiaofei.springclient.A");
//        Object b1 = c.newInstance();
//        B b = new B();
//        b.setA(b1);
//        b.f2();
//        System.out.println(((Class)c).getClassLoader());
//        System.out.println(c.getName());


//        Runnable r1 = new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("---->  This is "+Thread.currentThread().getName());
//                Demo a = Demo.getInstance();
//                System.out.println("<----  This is "+Thread.currentThread().getName());
//            }
//        };
//        Runnable r2 = new Runnable(){
//
//            @Override
//            public void run() {
//                System.out.println("---->  This is "+Thread.currentThread().getName());
//                Demo a = Demo.getInstance();
//                System.out.println("<----  This is "+Thread.currentThread().getName());
//            }
//        };
//
//        new Thread(r1).start();
//        new Thread(r2).start();
//
//
//        Class.forName("");
//        Class.forName("",true,new MyClassLoader());

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        String s = System.getProperty("sun.boot.class.path");
        String[] ss = s.split(":");
        for(int i = 0 ; i < ss.length ; i++){
            System.out.println(ss[i]);
        }

//        new Launcher();
        MyClassLoader classLoader = new MyClassLoader();

        classLoader.loadClass("java.lang.String");
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        classLoader1.getParent();
    }
}



class MyClassLoader extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String filename = name.substring(name.lastIndexOf(".")+1)+ ".class";
        try {
            InputStream is = getClass().getResourceAsStream(filename);
            if (is == null) {
                return super.loadClass(name);
            }
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name,b,0,b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadClass(name, false);
    }
}
class Demo{

    private static Demo demo  ;

    static {
        demo = new Demo();
    }

    private Demo(){
        System.out.println("初始化！");
        while (true){}
    }

    public static Demo getInstance(){
        System.out.println("初始化！");
        if(demo == null){
            demo = new Demo();
        }
        while (true)
        return demo;
    }


}
