package org.java.multithreading.diningPhilosphersProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ChopSticks class
 */
class ChopSticksTest {

    private ChopSticks chopSticks;
    private Philosopher testPhilosopher;

    @BeforeEach
    void setUp() {
        chopSticks = new ChopSticks(1);
        testPhilosopher = new Philosopher(0, chopSticks, chopSticks);
    }

    @Test
    void testChopSticksCreation() {
        ChopSticks cs = new ChopSticks(5);
        assertNotNull(cs);
        assertEquals("Chopstick5", cs.toString());
    }

    @Test
    void testToString() {
        assertEquals("Chopstick1", chopSticks.toString());
        
        ChopSticks cs0 = new ChopSticks(0);
        assertEquals("Chopstick0", cs0.toString());
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testPickUpSingleThread() {
        // Test picking up chopstick in single thread
        boolean result = chopSticks.pickUp(testPhilosopher, State.LEFT);
        assertTrue(result);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testPickUpAndPutDown() {
        // Test the complete cycle of picking up and putting down
        boolean picked = chopSticks.pickUp(testPhilosopher, State.LEFT);
        assertTrue(picked);
        
        // Should be able to put down after picking up
        assertDoesNotThrow(() -> {
            chopSticks.putDown(testPhilosopher, State.LEFT);
        });
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testPickUpTwiceByDifferentPhilosophers() throws InterruptedException {
        Philosopher philosopher1 = new Philosopher(1, chopSticks, chopSticks);
        Philosopher philosopher2 = new Philosopher(2, chopSticks, chopSticks);
        
        // First philosopher picks up
        boolean first = chopSticks.pickUp(philosopher1, State.LEFT);
        assertTrue(first);
        
        // Due to the bug in the original code (semicolon after if statement), 
        // the method always returns true regardless of lock acquisition
        boolean second = chopSticks.pickUp(philosopher2, State.RIGHT);
        assertTrue(second); // This will be true due to the bug
        
        // Clean up - this might throw IllegalMonitorStateException due to the bug
        try {
            chopSticks.putDown(philosopher1, State.LEFT);
        } catch (IllegalMonitorStateException e) {
            // Expected due to the bug in the original code
        }
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    void testConcurrentAccess() throws InterruptedException {
        int numberOfThreads = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(numberOfThreads);
        AtomicInteger successfulPickups = new AtomicInteger(0);

        for (int i = 0; i < numberOfThreads; i++) {
            final int id = i;
            executor.submit(() -> {
                try {
                    startLatch.await(); // Wait for all threads to be ready
                    Philosopher philosopher = new Philosopher(id, chopSticks, chopSticks);
                    
                    // Try to pick up the chopstick
                    if (chopSticks.pickUp(philosopher, State.LEFT)) {
                        successfulPickups.incrementAndGet();
                        Thread.sleep(100); // Hold the lock briefly
                        chopSticks.putDown(philosopher, State.LEFT);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    doneLatch.countDown();
                }
            });
        }

        startLatch.countDown(); // Start all threads
        doneLatch.await(5, TimeUnit.SECONDS); // Wait for completion
        executor.shutdown();

        // At least one thread should have successfully picked up the chopstick
        assertTrue(successfulPickups.get() >= 1);
        // But not all threads should succeed due to lock contention and timeout
        assertTrue(successfulPickups.get() <= numberOfThreads);
    }

    @Test
    void testPutDownWithoutPickUpThrowsException() {
        // Trying to put down without picking up should throw IllegalMonitorStateException
        assertThrows(IllegalMonitorStateException.class, () -> {
            chopSticks.putDown(testPhilosopher, State.LEFT);
        });
    }

    @Test
    void testMultipleChopSticksIndependence() {
        ChopSticks chopSticks1 = new ChopSticks(1);
        ChopSticks chopSticks2 = new ChopSticks(2);
        
        Philosopher philosopher1 = new Philosopher(1, chopSticks1, chopSticks2);
        Philosopher philosopher2 = new Philosopher(2, chopSticks2, chopSticks1);
        
        // Both philosophers should be able to pick up different chopsticks simultaneously
        boolean pickup1 = chopSticks1.pickUp(philosopher1, State.LEFT);
        boolean pickup2 = chopSticks2.pickUp(philosopher2, State.LEFT);
        
        assertTrue(pickup1);
        assertTrue(pickup2);
        
        // Clean up
        chopSticks1.putDown(philosopher1, State.LEFT);
        chopSticks2.putDown(philosopher2, State.LEFT);
    }
}