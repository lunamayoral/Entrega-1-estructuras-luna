import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorListaBasicaTest {

    @Test
    void hasNext() {
        ListaBasica<String> lista = new ListaBasica<>(5);
        IteradorListaBasica<String> iterador = new IteradorListaBasica<>(lista);
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        assertTrue(iterador.hasNext()); // Debería haber un siguiente elemento
        iterador.next(); // Avanzamos al siguiente
        assertTrue(iterador.hasNext()); // Debería haber otro siguiente elemento
        iterador.next(); // Avanzamos al siguiente
        assertTrue(iterador.hasNext()); // Debería haber otro siguiente elemento
        iterador.next(); // Avanzamos al siguiente
        assertFalse(iterador.hasNext()); // No debería haber más elementos
    }

    @Test
    void next() {
        ListaBasica<String> lista = new ListaBasica<>(5);
        IteradorListaBasica<String> iterador = new IteradorListaBasica<>(lista);
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        assertEquals("Elemento 1", iterador.next()); // Debería devolver el primer elemento
        assertEquals("Elemento 2", iterador.next()); // Debería devolver el segundo elemento
        assertEquals("Elemento 3", iterador.next()); // Debería devolver el tercer elemento
        assertNull(iterador.next()); // No debería haber más elementos, así que debería devolver null

    }

    @Test
    void delete() {
        ListaBasica<String> lista = new ListaBasica<>(5);
        IteradorListaBasica<String> iterador = new IteradorListaBasica<>(lista);
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        iterador.next(); // Avanzamos al primer elemento
        iterador.delete(); // Borramos el primer elemento
        assertEquals(2, lista.getNumElementos()); // Debería haber 2 elementos restantes
        assertEquals("Elemento 2", lista.getElemento(0)); // El primer elemento ahora debería ser "Elemento 2"
        assertEquals("Elemento 3", lista.getElemento(1)); // El segundo elemento debería ser "Elemento 3"

        iterador.next(); // Avanzamos al siguiente elemento (que es "Elemento 2")
        iterador.delete(); // Borramos "Elemento 2"
        assertEquals(1, lista.getNumElementos()); // Debería haber 1 elemento restante
        assertEquals("Elemento 3", lista.getElemento(0)); // El único elemento restante debería ser "Elemento 3"
    }
}