package org.hqf.tutorials.java.thread.threadPool;

import org.hqf.tutorials.java.thread.MyCallable;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public void getThredResultByFuture() {
        try {
            FutureTask<Object> task = new FutureTask<Object>(new MyCallable());
            System.out.println("线程启动");
            new Thread(task).start();


            //get方法会一直阻塞，直到这个线程也就是call方法执行完毕
            //可以通过调用isDone()来异步的询问是否已经完成。
            System.out.println("task return : " + task.get().toString());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


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
}
