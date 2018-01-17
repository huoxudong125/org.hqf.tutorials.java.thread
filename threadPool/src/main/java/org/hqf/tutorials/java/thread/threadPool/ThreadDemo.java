package org.hqf.tutorials.java.thread.threadPool;

import org.hqf.tutorials.java.thread.common.MyCallable;
import org.hqf.tutorials.java.thread.common.MyRunnableWithException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {

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

    public void throwException(){
        Thread thread=new Thread(new MyRunnableWithException());
        thread.start();
    }



}
