package org.hqf.tutorials.java.thread.lock;

import java.util.concurrent.CyclicBarrier;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/11
 */
public class CyclicBarrierTest {
    public static final int MANY_TIMES = 10;
    private CyclicBarrier barrier;

    public static void main(String[] args) {
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        cyclicBarrierTest.runWithCombineFunc();
    }


    public void runWithCombineFunc() {

        barrier = new CyclicBarrier(2, combineFuncThread);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < MANY_TIMES; i++) {
                        System.out.println(Thread.currentThread().getName() + " start " + i);
                        barrier.await();
                        System.out.println(Thread.currentThread().getName() + " finish" + i + " \n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < MANY_TIMES; i++) {
                        System.out.println(Thread.currentThread().getName() + " start " + i);
                        barrier.await();
                        System.out.println(Thread.currentThread().getName() + " finish" + i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "thread B ").start();


    }

    Thread combineFuncThread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("combineFuncThread start");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("combineFuncThread finished");
            }

        }
    }, "combine_thread3");


}
