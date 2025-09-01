package org.java.multithreading.diningPhilosphersProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the State enum
 */
class StateTest {

    @Test
    void testStateEnumValues() {
        // Test that the enum has the expected values
        State[] values = State.values();
        assertEquals(2, values.length);
        
        assertEquals(State.LEFT, values[0]);
        assertEquals(State.RIGHT, values[1]);
    }

    @Test
    void testStateToString() {
        // Test string representation
        assertEquals("LEFT", State.LEFT.toString());
        assertEquals("RIGHT", State.RIGHT.toString());
    }

    @Test
    void testStateValueOf() {
        // Test valueOf method
        assertEquals(State.LEFT, State.valueOf("LEFT"));
        assertEquals(State.RIGHT, State.valueOf("RIGHT"));
    }

    @Test
    void testStateValueOfInvalid() {
        // Test valueOf with invalid value
        assertThrows(IllegalArgumentException.class, () -> {
            State.valueOf("INVALID");
        });
    }
}