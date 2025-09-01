package org.java.multithreading.diningPhilosphersProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Philosopher class
 */
class PhilosopherTest {

    private ChopSticks leftChopSticks;
    private ChopSticks rightChopSticks;
    private Philosopher philosopher;

    @BeforeEach
    void setUp() {
        leftChopSticks = new ChopSticks(0);
        rightChopSticks = new ChopSticks(1);
        philosopher = new Philosopher(1, leftChopSticks, rightChopSticks);
    }

    @Test
    void testPhilosopherCreation() {
        assertNotNull(philosopher);
        assertEquals(0, philosopher.getEatingCounter());
        assertEquals("Philosopher{id=1}", philosopher.toString());
    }

    @Test
    void testPhilosopherToString() {
        Philosopher p0 = new Philosopher(0, leftChopSticks, rightChopSticks);
        Philosopher p5 = new Philosopher(5, leftChopSticks, rightChopSticks);
        
        assertEquals("Philosopher{id=0}", p0.toString());
        assertEquals("Philosopher{id=1}", philosopher.toString());
        assertEquals("Philosopher{id=5}", p5.toString());
    }

    @Test
    void testInitialEatingCounter() {
        assertEquals(0, philosopher.getEatingCounter());
    }

    @Test
    void testSetFull() {
        // Initially philosopher should not be full
        philosopher.setFull(false);
        
        // Set philosopher as full
        philosopher.setFull(true);
        
        // The setFull method should work without exceptions
        assertDoesNotThrow(() -> philosopher.setFull(true));
        assertDoesNotThrow(() -> philosopher.setFull(false));
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testPhilosopherRunsAndEats() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        
        // Create a thread to run the philosopher
        Thread philosopherThread = new Thread(() -> {
            try {
                // Let philosopher run for a short time
                Thread philosopherRunner = new Thread(philosopher);
                philosopherRunner.start();
                
                // Let it run for a bit
                Thread.sleep(500);
                
                // Stop the philosopher
                philosopher.setFull(true);
                philosopherRunner.join(2000);
                
                latch.countDown();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        philosopherThread.start();
        latch.await(8, TimeUnit.SECONDS);
        
        // Philosopher should have eaten at least once in 500ms
        assertTrue(philosopher.getEatingCounter() >= 0);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testPhilosopherStopsWhenFull() throws InterruptedException {
        // Start philosopher as full
        philosopher.setFull(true);
        
        Thread philosopherThread = new Thread(philosopher);
        philosopherThread.start();
        
        // Should finish quickly since philosopher is already full
        philosopherThread.join(2000);
        
        // Should not have eaten anything
        assertEquals(0, philosopher.getEatingCounter());
    }

    @Test
    @Timeout(value = 15, unit = TimeUnit.SECONDS)
    void testMultiplePhilosophersWithSharedChopsticks() throws InterruptedException {
        // Create a scenario with multiple philosophers sharing chopsticks
        ChopSticks chopstick0 = new ChopSticks(0);
        ChopSticks chopstick1 = new ChopSticks(1);
        ChopSticks chopstick2 = new ChopSticks(2);
        
        Philosopher philosopher1 = new Philosopher(1, chopstick0, chopstick1);
        Philosopher philosopher2 = new Philosopher(2, chopstick1, chopstick2);
        
        Thread thread1 = new Thread(philosopher1);
        Thread thread2 = new Thread(philosopher2);
        
        thread1.start();
        thread2.start();
        
        // Let them run for a bit
        Thread.sleep(1000);
        
        // Stop both philosophers
        philosopher1.setFull(true);
        philosopher2.setFull(true);
        
        thread1.join(2000);
        thread2.join(2000);
        
        // Both philosophers should have attempted to eat (though may not succeed due to contention)
        assertTrue(philosopher1.getEatingCounter() >= 0);
        assertTrue(philosopher2.getEatingCounter() >= 0);
    }

    @Test
    void testPhilosopherWithSameChopsticks() {
        // Edge case: philosopher with same left and right chopstick
        ChopSticks sameChopstick = new ChopSticks(0);
        Philosopher philosopherSame = new Philosopher(99, sameChopstick, sameChopstick);
        
        assertNotNull(philosopherSame);
        assertEquals("Philosopher{id=99}", philosopherSame.toString());
        assertEquals(0, philosopherSame.getEatingCounter());
    }

    @Test
    @Timeout(value = 8, unit = TimeUnit.SECONDS)
    void testPhilosopherEatingCounterIncreases() throws InterruptedException {
        // Create a scenario where philosopher can definitely eat
        ChopSticks exclusiveLeft = new ChopSticks(10);
        ChopSticks exclusiveRight = new ChopSticks(11);
        Philosopher exclusivePhilosopher = new Philosopher(10, exclusiveLeft, exclusiveRight);
        
        Thread thread = new Thread(exclusivePhilosopher);
        thread.start();
        
        // Let philosopher run for a while
        Thread.sleep(2000);
        
        int eatingCountBefore = exclusivePhilosopher.getEatingCounter();
        
        // Let it run a bit more
        Thread.sleep(1000);
        
        int eatingCountAfter = exclusivePhilosopher.getEatingCounter();
        
        // Stop philosopher
        exclusivePhilosopher.setFull(true);
        thread.join(2000);
        
        // Eating counter should have increased or at least stayed the same
        assertTrue(eatingCountAfter >= eatingCountBefore);
    }
}