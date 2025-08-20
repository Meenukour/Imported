package org.java.multithreading;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class dummyWorker implements Runnable {
    CountDownLatch latch;
    private int id;
    public dummyWorker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("This is run in " + id);
        latch.countDown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

public class dummy {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            executorService.execute(new dummyWorker(i,latch));

latch.await();
        System.out.println("All tasks done");
        executorService.shutdown();

    }
}
