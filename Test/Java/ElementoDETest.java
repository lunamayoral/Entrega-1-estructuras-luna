import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoDETest {

    @Test
    void getDato() {
        ElementoDE<Integer> elemento = new ElementoDE<>(5);
        assertEquals(5, elemento.getDato());
    }

    @Test
    void setDato() {
        ElementoDE<Integer> elemento = new ElementoDE<>(5);
        elemento.setDato(10);
        assertEquals(10, elemento.getDato());
    }

    @Test
    void getSiguiente() {
        ElementoDE<Integer> elemento1 = new ElementoDE<>(5);
        ElementoDE<Integer> elemento2 = new ElementoDE<>(7);
        elemento1.setSiguiente(elemento2);
        assertEquals(elemento2, elemento1.getSiguiente());
    }

    @Test
    void setSiguiente() {
        ElementoDE<Integer> elemento1 = new ElementoDE<>(5);
        ElementoDE<Integer> elemento2 = new ElementoDE<>(10);
        elemento1.setSiguiente(elemento2);

        assertEquals(elemento2, elemento1.getSiguiente());

        ElementoDE<Integer> elemento3 = new ElementoDE<>(15);
        elemento1.setSiguiente(elemento3);

        assertEquals(elemento3, elemento1.getSiguiente());
    }

    @Test
    void getAnterior() {
        ElementoDE<Integer> elemento1 = new ElementoDE<>(5);
        ElementoDE<Integer> elemento2 = new ElementoDE<>(10);
        elemento2.setAnterior(elemento1);

        assertEquals(elemento1, elemento2.getAnterior());
    }

    @Test
    void setAnterior() {
        ElementoDE<Integer> elemento1 = new ElementoDE<>(5);
        ElementoDE<Integer> elemento2 = new ElementoDE<>(10);
        elemento2.setAnterior(elemento1);

        assertEquals(elemento1, elemento2.getAnterior());

        ElementoDE<Integer> elemento3 = new ElementoDE<>(15);
        elemento2.setAnterior(elemento3);

        assertEquals(elemento3, elemento2.getAnterior());
    }
}