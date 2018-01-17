package org.hqf.tutorials.java.thread.threadPool;

import org.junit.Test;

public class ThreadPoolTest {


    @Test
    public void getThreadResultByFuture() {
        ThreadPoolDemo threadPool=new ThreadPoolDemo();
        threadPool.getThredResultByFuture();

    }


    @Test
    public void getThreadPoolResultByFuture() {
        ThreadPoolDemo threadPool=new ThreadPoolDemo();
        threadPool.getThredPoolResultByFuture();

    }


}