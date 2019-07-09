package org.hqf.tutorials.java.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * 若 读锁 被占用，则申请写锁的线程会等待，申请读锁的线程不用等待
 * 若 写锁 被占用，则申请写锁或读锁的线程都会等待
 *
 * ReadWriteLock 为读写锁的接口，ReentrantReadWriteLock 为一个实现类。
 *
 * 通过 Lock readLock(); 方法得到读锁
 * 通过 Lock writeLock(); 方法得到写锁
 *
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/09
 */
public class ReadWriteLock_Test {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static int count = 0;

    public static void readCount() {
        // 申请读锁
        lock.readLock().lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " is reading count: " + count);
        // 申请读锁
        lock.readLock().unlock();
    }

    public static void writeCount() {
        // 申请写锁
        lock.writeLock().lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " is writing count: " + count++);
        // 释放写锁
        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            (new ReadThread()).start();
        }

        for (int i = 0; i < 5; i++) {
            (new WriteThread()).start();
        }
    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            readCount();
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            writeCount();
        }
    }
}
