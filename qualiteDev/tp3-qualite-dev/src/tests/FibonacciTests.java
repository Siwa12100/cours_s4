package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests pour la classe Fibonacci")
class FibonacciTests {

    @Test
    @DisplayName("Test d'instanciation de la classe Fibonacci")
    void testInstanciationFibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        assertNotNull(fibonacci, "L'instance de Fibonacci ne doit pas être nulle");
    }

    @Test
    @DisplayName("Test de la valeur F(0) dans la suite de Fibonacci")
    void testFibonacciF0() {
        Fibonacci fibonacci = new Fibonacci();
        int resultat = fibonacci.calculFibonacci(0);
        assertEquals(0, resultat, "F(0) doit retourner 0");
    }

    @Test
    @DisplayName("Test de la valeur F(1) dans la suite de Fibonacci")
    void testFibonacciF1() {
        Fibonacci fibonacci = new Fibonacci();
        int resultat = fibonacci.calculFibonacci(1);
        assertEquals(1, resultat, "F(1) doit retourner 1");
    }
}



