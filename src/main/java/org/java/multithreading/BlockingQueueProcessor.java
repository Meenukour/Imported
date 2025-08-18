package org.java.multithreading;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * BlockingQueueProcessor - Demonstrates Producer-Consumer pattern using BlockingQueue
 * 
 * This example shows how to use BlockingQueue for thread-safe communication between
 * producer and consumer threads. BlockingQueue automatically handles synchronization
 * and provides blocking operations when the queue is full (put) or empty (take).
 * 
 * Key concepts demonstrated:
 * - Producer-Consumer pattern
 * - Thread-safe collections
 * - Blocking operations
 * - ArrayBlockingQueue with bounded capacity
 * 
 * Run this example and observe how producer and consumer threads coordinate
 * through the shared BlockingQueue.
 */

/**
 * FirstWorker - Producer thread that adds elements to the BlockingQueue
 * Produces integers in sequence and puts them into the shared queue
 */
class FirstWorker implements  Runnable
{
private BlockingQueue<Integer> blockingQueue;

public FirstWorker(BlockingQueue<Integer> blockingQueue)
{
this.blockingQueue = blockingQueue;
}
    /**
     *
     */
    @Override
    public void run() {
        int counter =0;
while(true)
{
    try {
        blockingQueue.put(counter);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    System.out.println("Putting elements in queue"  +counter);
counter++;
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    }
}
/**
 * SecondWorker - Consumer thread that removes elements from the BlockingQueue
 * Consumes integers from the queue and processes them
 */
class SecondWorker implements  Runnable
{
    private BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue)
    {
        this.blockingQueue = blockingQueue;
    }
    /**
     *
     */
    @Override
    public void run() {

        while(true)
        {
            try {
              int counter =  blockingQueue.take();
                System.out.println("Taking elements from queue  " +counter);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
}

/**
 * Main application class demonstrating BlockingQueue usage
 * Creates a bounded queue and starts producer and consumer threads
 */
public class BlockingQueueProcessor {

    /**
     * Main method - sets up the producer-consumer scenario
     * Creates a BlockingQueue with capacity 10 and starts worker threads
     */
    public static void main(String[] args) {
        // Create a bounded BlockingQueue with capacity of 10 elements
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        
        // Create producer and consumer workers
        FirstWorker firstWorker = new FirstWorker(blockingQueue);
        SecondWorker secondWorker = new SecondWorker(blockingQueue);
        
        // Start both threads - they will communicate through the shared queue
        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}
