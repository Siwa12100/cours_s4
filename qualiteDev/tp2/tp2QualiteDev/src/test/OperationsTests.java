package test;

import operations.Operations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTests {

    @Test
    void additionner() {

        assertEquals(10, Operations.additionner(4,6));
        assertEquals(-3, Operations.additionner(4, 6, -13));
        assertThrows(ArithmeticException.class, () -> Operations.additionner(8));

    }

    @Test
    void multiplier() {
        assertEquals(0, Operations.multiplier(2, 9, 8, 0));
        assertEquals(9, Operations.multiplier(1, 3, 3));
        assertThrows(ArithmeticException.class, () -> Operations.multiplier(9));
    }

    @Test
    void diviser() {
        assertEquals(1, Operations.diviser(9, 9));
        assertEquals(3, Operations.diviser(15, 5));
        assertThrows(ArithmeticException.class, () -> Operations.diviser(9, 8, 7, 0));
        assertThrows(ArithmeticException.class, () -> Operations.diviser(9));
    }

    @Test
    void pythagore() {
        assertEquals(true, Operations.pythagore(8, 6, 10));
        assertEquals(true, Operations.pythagore(2, 2, 2));
        assertThrows(ArithmeticException.class, () -> Operations.pythagore(-5, 8, 9));
    }
}
