package org.hqf.tutorials.java.thread.threadPool;

import org.hqf.tutorials.java.po.Data;
import org.hqf.tutorials.java.thread.common.*;

import java.util.concurrent.*;

public class ThreadPoolDemo {




    public void getThredPoolResultByFuture(){
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        Future<Object> future = newCachedThreadPool.submit(new MyCallable());
        try {
            //同样可以通过future.isDone()来异步的知道线程是否已经处理完毕
            System.out.println(future.get().toString());
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown();
        }
    }

    public void getThredPoolRunaleResultByFuture(){
        ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(1);

        Data data = new Data();
        Future future = newCachedThreadPool.submit(new MyRunableWithParam(data), data);

        try {
            //同样可以通过future.isDone()来异步的知道线程是否已经处理完毕
            System.out.println(future.get().toString());
            System.out.println("data = " + data);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown();
        }
    }
}
