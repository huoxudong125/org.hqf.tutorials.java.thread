package org.hqf.tutorials.java.thread.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 *
 *     在API中是这样描述的：
 * 用给定的计数 初始化 CountDownLatch。由于调用了 countDown() 方法，所以在当前计数到达零之前，await 方法会一直受阻塞。之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。
 *
 *
 * 经典的java并发编程实战一书中做了更深入的定义：
 * CountDownLatch属于闭锁的范畴，闭锁是一种同步工具类，可以延迟线程的进度直到其到达终止状态。闭锁的作用相当于一扇门：在闭锁到达结束状态之前(上面代码中的runningThreadNumq清0)，这扇门一直是关闭的，并且没有任何线程能通过(上面代码中的主线程一直await)，当到达结束状态时，这扇门会打开并允许所有线程通过(上面代码中的主线程可以继续执行)。当闭锁到达结束状态后，将不会再改变状态，因此这扇门将永远保持打开状态。
 *
 *
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/07/11
 */
public class CountDownLatchTest {


    public static void main(String[] args) {
        List<DealRequest> requestList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DealRequest request = new DealRequest();
            requestList.add(request);

            request.setRequestId(i);
        }

        CountDownLatchTest countDownLatchTest=new CountDownLatchTest();

        countDownLatchTest.countDownDeal(requestList);
    }

    /**
     * 使用countdownlatch的批次请求处理服务
     *
     * @param batchRequests 批次请求对象列表
     * @return
     */
    public List<DealResult>  countDownDeal(List<DealRequest> batchRequests) {

        //定义线程安全的处理结果列表
        List<DealResult> countDownResultList = Collections.synchronizedList(new ArrayList<DealResult>());

        if (batchRequests != null) {

            //定义countdownlatch线程数，有多少个请求，我们就定义多少个
            CountDownLatch runningThreadNum = new CountDownLatch(batchRequests.size());

            for (DealRequest request : batchRequests) {
                //循环遍历请求，并实例化线程(构造函数传入CountDownLatch类型的runningThreadNum)，立刻启动
                DealWorker dealWorker = new DealWorker(request, runningThreadNum, countDownResultList);
                new Thread(dealWorker).start();
            }

            try {
                //调用CountDownLatch的await方法则当前主线程会等待，直到CountDownLatch类型的runningThreadNum清0
                //每个DealWorker处理完成会对runningThreadNum减1
                //如果等待1分钟后当前主线程都等不到runningThreadNum清0，则认为超时，直接中断，抛出中断异常InterruptedException
                runningThreadNum.await(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                //此处简化处理，非正常中断应该抛出异常或返回错误结果
                return null;
            }
        }
        return countDownResultList;
    }

    /**
     * 线程请求处理类
     */
    private class DealWorker implements Runnable {

        /**
         * 正在运行的线程数
         */
        private CountDownLatch runningThreadNum;

        /**
         * 待处理请求
         */
        private DealRequest request;

        /**
         * 待返回结果列表
         */
        private List<DealResult> countDownResultList;

        /**
         * 构造函数
         *
         * @param request             待处理请求
         * @param runningThreadNum    正在运行的线程数
         * @param countDownResultList 待返回结果列表
         */
        private DealWorker(DealRequest request, CountDownLatch runningThreadNum, List<DealResult> countDownResultList) {
            this.request = request;
            this.runningThreadNum = runningThreadNum;
            this.countDownResultList = countDownResultList;
        }

        @Override
        public void run() {
            try {
                this.countDownResultList.add(process(this.request));
            } finally {
                //当前线程处理完成，runningThreadNum线程数减1，此操作必须在finally中完成，避免处理异常后造成runningThreadNum线程数无法清0
                this.runningThreadNum.countDown();
            }
        }

        private DealResult process(DealRequest request) {
            System.out.println("request.getRequestId() = " + request.getRequestId());
            return null;
        }
    }

    private static class DealRequest {
        private int requestId;

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }
    }

    private static class DealResult {

    }

}
