package org.hqf.tutorials.java.thread.demo.biz;


import org.hqf.tutorials.java.thread.lock.CyclicBarrierTest;

import java.util.concurrent.CyclicBarrier;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/12
 */
public class BizDeliverOrder implements Runnable{

    private final CyclicBarrier cyclicBarrier=new CyclicBarrier(2);

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

        MockOrderData.getDeliveredOrders();
        cyclicBarrier.notify();


    }
}
