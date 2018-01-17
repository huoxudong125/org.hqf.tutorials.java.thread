package org.hqf.tutorials.java.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object> {

    public Object call() throws Exception {
        int i=10;
        Thread.sleep(10000);
        return i;
    }

}