package org.hqf.tutorials.java.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * ReentrantLock和synchronized都是可重入锁，
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/11
 */
public class ReentrantTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    static class ThreadTest implements Runnable {

        private volatile int count;
        private Thread predecessor;

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " Started");
            try {
                reentrantLock.lock();
                while (count < 1000) {
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + " " + count++);
                }
                if (predecessor != null) {
                    predecessor.join();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + " Finished");
            }

        }

        public void setPredecessor(Thread t) {
            this.predecessor = t;
        }
    }


    public static void main(String[] args) {

        ReentrantTest reentrantTest = new ReentrantTest();
        reentrantTest.run();
    }

    public void run() {
        try {
            reentrantLock.lock();
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

            ThreadTest threadTestA = new ThreadTest();
            ThreadTest threadTestB = new ThreadTest();

            ThreadTest threadTestC = new ThreadTest();

            Thread threadA = new Thread(threadTestA);
            threadA.start();

            threadTestB.setPredecessor(threadA);
            Thread threadB = new Thread(threadTestB);
            threadB.start();

            threadTestC.setPredecessor(threadB);
            Thread threadC = new Thread(threadTestC);
            threadC.start();

            //这种方法无法实现，所有线程都阻塞
//            threadA.join();
//            threadB.join();
//            threadC.join();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


}
