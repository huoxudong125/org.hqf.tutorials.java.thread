package org.hqf.tutorials.java.thread.common;


public class NumberPrinter implements Runnable {

    private int number = 0;
    private final Object lock;
    private final boolean isOdd;
    private final int maxNumber;

    public NumberPrinter(Object lock, boolean isOdd, int maxNumber) {
        this.lock = lock;
        this.isOdd = isOdd;
        this.maxNumber = maxNumber;

        if (isOdd) {
            number = 1;
        } else {
            number = 2;
        }

    }

    public void run() {

        while (number < maxNumber) {
            System.out.println(" " + (isOdd ? "奇数" : "偶数") + "  maxNumber=" + maxNumber);
            synchronized (lock) {
                System.out.println("number = " + number);


                number += 2;
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
