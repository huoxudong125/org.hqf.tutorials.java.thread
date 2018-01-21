import java.util.concurrent.CountDownLatch;

public class WorkerRunnableParter implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;
    WorkerRunnableParter(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }
    public void run() {
        try {
            doWork(i);
            doneSignal.countDown();
        } catch (InterruptedException ex) {} // return;
    }

    void doWork(int i)throws InterruptedException {

        Thread.sleep(100);
        System.out.println("i = " + i+" CurrentThreadName:"+Thread.currentThread().getName());

        //int p=1/0;
    }


}