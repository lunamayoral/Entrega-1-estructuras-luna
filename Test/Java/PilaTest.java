import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaTest {

    @Test
    void push() {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(3, pila.peek());
        assertEquals(3, pila.size());
    }

    @Test
    void pop() {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(3, pila.pop()); // Debe devolver 3
        assertEquals(2, pila.size()); // La pila debe tener 2 elementos después del pop
        assertEquals(2, pila.peek()); // El nuevo elemento en la parte superior debe ser 2

        Pila<Integer> pila2 = new Pila<>();
        assertNull(pila2.pop());
    }

    @Test
    void peek() {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        assertEquals(3, pila.peek());

        Pila<Integer> pila2 = new Pila<>();
        assertNull(pila2.peek());
    }

    @Test
    void vacia() {
        Pila<Integer> pila = new Pila<>();
        assertTrue(pila.vacia());
        pila.push(1);
        assertFalse(pila.vacia());
    }

    @Test
    void size() {
    }
}