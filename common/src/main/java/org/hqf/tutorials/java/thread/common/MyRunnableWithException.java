package org.hqf.tutorials.java.thread.common;

public class MyRunnableWithException implements Runnable {

    //Will throw exception
    public void run() {
        int i = 1 / 0;
        System.out.println("i = " + i);
    }
}
