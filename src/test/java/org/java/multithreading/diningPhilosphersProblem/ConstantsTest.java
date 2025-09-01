package org.java.multithreading.diningPhilosphersProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Constants class
 */
class ConstantsTest {

    @Test
    void testNumberOfPhilosophers() {
        assertEquals(5, Constants.NUMBER_OF_PHILOSOPHERS);
    }

    @Test
    void testNumberOfChopsticks() {
        assertEquals(5, Constants.NUMBER_OF_CHOPSTICKS);
    }

    @Test
    void testSimulationRunningTime() {
        assertEquals(5 * 2000, Constants.SIMULATION_RUNNING_TIME);
        assertEquals(10000, Constants.SIMULATION_RUNNING_TIME);
    }

    @Test
    void testPhilosophersAndChopsticksMatch() {
        // In the dining philosophers problem, number of chopsticks should equal number of philosophers
        assertEquals(Constants.NUMBER_OF_PHILOSOPHERS, Constants.NUMBER_OF_CHOPSTICKS);
    }

    @Test
    void testSimulationTimeIsPositive() {
        assertTrue(Constants.SIMULATION_RUNNING_TIME > 0);
    }
}