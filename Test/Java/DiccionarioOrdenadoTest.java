import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioOrdenadoTest {
    private DiccionarioOrdenado<Integer, String> diccionarioAscendente;
    private DiccionarioOrdenado<Integer, String> diccionarioDescendente;

    @Test
    void getOrdenador() {
        DiccionarioOrdenado<String, Integer> dicc = new DiccionarioOrdenado<>(true);
        assertTrue(dicc.getOrdenador().getOrdenAscendente());
    }

    @Test
    void add() {
        diccionarioAscendente = new DiccionarioOrdenado<>(true);
        diccionarioDescendente = new DiccionarioOrdenado<>(false);

        assertTrue(diccionarioAscendente.add(1, "Uno"));
        assertEquals("Uno", diccionarioAscendente.getCabeza().getValue());
        assertEquals("Uno", diccionarioAscendente.getCola().getValue());
        assertNull(diccionarioAscendente.getCabeza().getAnterior());
        assertNull(diccionarioAscendente.getCola().getSiguiente());
        diccionarioAscendente.add(3, "Tres");
        diccionarioAscendente.add(1, "Uno");
        diccionarioAscendente.add(2, "Dos");

        assertEquals("Uno", diccionarioAscendente.getCabeza().getValue());
        assertEquals("Tres", diccionarioAscendente.getCola().getValue());
        assertEquals(1, diccionarioAscendente.getCabeza().getKey());
        assertEquals(3, diccionarioAscendente.getCola().getKey());
        assertEquals(1, diccionarioAscendente.getCabeza().getSiguiente().getKey());
        assertEquals(2, diccionarioAscendente.getCabeza().getSiguiente().getSiguiente().getKey());
        diccionarioDescendente.add(1, "Uno");
        diccionarioDescendente.add(3, "Tres");
        diccionarioDescendente.add(2, "Dos");

        assertEquals("Tres", diccionarioDescendente.getCabeza().getValue());
        assertEquals("Uno", diccionarioDescendente.getCola().getValue());
        assertEquals(3, diccionarioDescendente.getCabeza().getKey());
        assertEquals(1, diccionarioDescendente.getCola().getKey());
        assertEquals(2, diccionarioDescendente.getCabeza().getSiguiente().getKey());
        assertEquals(2, diccionarioDescendente.getCola().getAnterior().getKey());

        diccionarioAscendente.add(2, "Dos");
        diccionarioAscendente.add(1, "Uno"); // Debe ir al inicio

        assertEquals("Uno", diccionarioAscendente.getCabeza().getValue());
        assertEquals(1, diccionarioAscendente.getCabeza().getKey());
        assertEquals("Uno", diccionarioAscendente.getCabeza().getSiguiente().getValue());

        diccionarioAscendente.add(1, "Uno");
        diccionarioAscendente.add(2, "Dos"); // Debe ir al final

        assertEquals("Tres", diccionarioAscendente.getCola().getValue());
        assertEquals(3, diccionarioAscendente.getCola().getKey());
        assertEquals("Uno", diccionarioAscendente.getCabeza().getValue());

        diccionarioAscendente.add(1, "Uno");
        diccionarioAscendente.add(3, "Tres");
        diccionarioAscendente.add(2, "Dos"); // Debe ir en el medio

        assertEquals(1, diccionarioAscendente.getCabeza().getSiguiente().getKey());
        assertEquals("Uno", diccionarioAscendente.getCabeza().getSiguiente().getValue());
    }
}