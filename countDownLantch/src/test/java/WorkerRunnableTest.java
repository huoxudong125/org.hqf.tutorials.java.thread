import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class WorkerRunnableTest {

private final int N=10;


    @Test
    public void Test() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new WorkerRunnable(startSignal, doneSignal)).start();

        //doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        //doSomethingElse();
        doneSignal.await();           // wait for all to finish

        System.out.println("主线程结束");
    }


    @Test
    public void TestWorkerRunnableParter() throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(N);
        Executor e = Executors.newCachedThreadPool();


        for (int i = 0; i < N; ++i) // create and start threads
            e.execute(new WorkerRunnableParter(doneSignal, i));

        doneSignal.await();           // wait for all to finish
    }


}