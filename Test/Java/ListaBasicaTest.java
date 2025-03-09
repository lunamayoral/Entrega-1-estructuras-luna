import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaBasicaTest {

    @Test
    void setElemento() {
        ListaBasica<String> lista = new ListaBasica<>(5);
        lista.setElemento(0, "A");
        assertEquals("A", lista.getElemento(0));

        lista.setElemento(1, "B");
        assertEquals("B", lista.getElemento(1));

        // Test fuera de rango
        lista.setElemento(-1, "C"); // Debería imprimir mensaje de error
        lista.setElemento(5, "D");  // Debería imprimir mensaje de error

    }

    @Test
    void getElemento() {
        ListaBasica<String> lista = new ListaBasica<>(5);
        lista.setElemento(0, "A");
        lista.setElemento(1, "B");

        assertEquals("A", lista.getElemento(0));
        assertEquals("B", lista.getElemento(1));
        assertNull(lista.getElemento(7));
    }

    @Test
    void mostrarElementos() {

    }

    @Test
    void add() {
        ListaBasica<String> lista = new ListaBasica<>(2);
        assertTrue(lista.add("A"));
        assertTrue(lista.add("B"));
        assertFalse(lista.add("C"));
        assertEquals(2, lista.getNumElementos());
    }

    @Test
    void delete() {
        ListaBasica<Integer> lista0 = new ListaBasica<>(3);
       assertFalse(lista0.delete(1));
        assertEquals(0, lista0.getNumElementos());

        ListaBasica<String> lista = new ListaBasica<>(5);
        lista.add("A");
        lista.add("B");

        assertTrue(lista.delete("A"));
        assertFalse(lista.delete("C"));
        assertEquals(1, lista.getNumElementos());

        // Verifica que el elemento en el índice 0 sea "B"
        assertEquals("B", lista.getElemento(0));
    }

    @Test
    void getNumElementos() {
        ListaBasica<String> lista = new ListaBasica<>(5);
        lista.add("A");
        lista.add("B");
        lista.add("C");
        assertEquals(3, lista.getNumElementos());
    }

    @Test
    void getIterador() {
        Lista<Integer> lista = new ListaBasica<>(6);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.delete(2);
        List<Integer> resultado = new ArrayList<>();
        IIterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(1, 3), resultado);
    }
}