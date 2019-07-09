package org.hqf.tutorials.java.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/09
 */
public class ReentrantLockInterrupt {

    private Lock lock = new ReentrantLock();

    private int count = 0;

    private int incrementAndGetCount() {
        try {
            // 想要能够响应中断，需使用 lock.lockInterruptibly(); 而不能是 lock.lock();
            lock.lockInterruptibly();

            System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
            return count++;
        } catch (Exception e) {
            return 0;
        } finally {
            // 并没有在 finally 中释放锁
            // lock.unlock();
        }
    }

    public static void main(String[] args) {
      final ReentrantLockInterrupt test = new ReentrantLockInterrupt();

        Thread t1 = new Thread() {

            @Override
            public void run() {

                Thread.currentThread().setName("THREAD-A");
                test.incrementAndGetCount();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("THREAD-B");
                test.incrementAndGetCount();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };

        t2.start();
        t1.start();
        t2.interrupt();
    }
}
