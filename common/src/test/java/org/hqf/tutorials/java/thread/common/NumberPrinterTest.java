package org.hqf.tutorials.java.thread.common;


import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinterTest {

    @Test
    public void TestPrinter() throws InterruptedException {

        Object lock = new Object();
        Thread threadOdd = new Thread(new NumberPrinter(lock, true, 100));
        Thread threadEven = new Thread(new NumberPrinter(lock, false, 100));


        threadEven.start();
        threadOdd.start();

        threadOdd.join();
        threadEven.join();


        System.out.println("结束");

    }

}