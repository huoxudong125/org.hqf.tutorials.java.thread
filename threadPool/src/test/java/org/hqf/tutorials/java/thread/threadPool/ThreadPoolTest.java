package org.hqf.tutorials.java.thread.threadPool;

import org.junit.Test;

public class ThreadPoolTest {


    @Test
    public void getThreadResultByFuture() {
        ThreadDemo threadPool=new ThreadDemo();
        threadPool.getThredResultByFuture();

    }


    @Test
    public void getThreadPoolResultByFuture() {
        ThreadPoolDemo threadPool=new ThreadPoolDemo();
        threadPool.getThredPoolResultByFuture();

    }
    @Test
    public void getThreadPoolRunnableResultByFuture() {
        ThreadPoolDemo threadPool=new ThreadPoolDemo();
        threadPool.getThredPoolRunaleResultByFuture();

    }


}