import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaTest {

    @Test
    void testCola() {
        Cola<Integer> cola = new Cola<>();
        cola.enqueue(10);
        cola.enqueue(20);
        assertEquals(10, cola.dequeue());
    }

    @Test
    void enqueue() {
        Cola<Integer> cola = new Cola();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);

        assertEquals(1, cola.peek());
        assertEquals(3, cola.size());
    }

    @Test
    void dequeue() {
        Cola<Integer> cola = new Cola();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        assertEquals(1, cola.dequeue()); // Debe devolver 1
        assertEquals(2, cola.size());     // La cola debe tener 2 elementos después del dequeue
        assertEquals(2, cola.peek());      // El nuevo elemento en la parte frontal debe ser 2

        Cola<Integer> cola2 = new Cola();
        assertNull(cola2.dequeue());
    }

    @Test
    void vacia() {
        Cola<Integer> cola = new Cola();
        assertTrue(cola.vacia());
        cola.enqueue(1);
        assertFalse(cola.vacia());
    }

    @Test
    void size() {
        Cola<Integer> cola = new Cola();
        assertEquals(0, cola.size());
        cola.enqueue(1);
        assertEquals(1, cola.size());
    }

    @Test
    void peek() {
        Cola<Integer> cola = new Cola();
        cola.enqueue(1);
        cola.enqueue(2);
        assertEquals(1, cola.peek());

        Cola<Integer> cola2 = new Cola();
        assertNull(cola2.peek());
    }
}