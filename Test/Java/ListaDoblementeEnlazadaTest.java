import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaDoblementeEnlazadaTest {

    @Test
    void testListaDoblementeEnlazada() {
        Lista<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(5);
        lista.add(15);
        lista.add(25);
        lista.delete(15);
        List<Integer> resultado = new ArrayList<>();
        IIterador<Integer> iterador = lista.getIterador();
        while (iterador.hasNext()) {
            resultado.add(iterador.next());
        }
        assertEquals(List.of(5, 25), resultado);
    }

    @Test
    void add() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertTrue(lista.add(3));
        assertEquals(3, lista.getNumElementos());
    }

    @Test
    void insert() {
        // Caso 1: Insertar en una lista vacía
        ListaDoblementeEnlazada<Integer> lista1 = new ListaDoblementeEnlazada<>();
        lista1.insert(null, 1); // Debe agregar 1 como el primer elemento
        assertEquals(1, lista1.getNumElementos());
        assertEquals(1, lista1.cabeza.getDato());
        assertEquals(1, lista1.cola.getDato());

        // Caso 2: Insertar al inicio de la lista
        ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<>();
        lista2.add(1); // Lista: 1
        ElementoDE<Integer> elemento2 = lista2.cabeza; // Elemento que contiene 1
        lista2.insert(elemento2, 0); // Lista después de la inserción: 0, 1
        assertEquals(2, lista2.getNumElementos());
        IIterador<Integer> iterador2 = lista2.getIterador();
        assertEquals(0, iterador2.next());
        assertEquals(1, iterador2.next());

        // Caso 3: Insertar en medio de la lista
        ListaDoblementeEnlazada<Integer> lista3 = new ListaDoblementeEnlazada<>();
        lista3.add(1); // Lista: 1
        lista3.add(3); // Lista: 1, 3
        ElementoDE<Integer> elemento3 = lista3.cabeza.siguiente; // Elemento que contiene 3
        lista3.insert(elemento3, 2); // Lista después de la inserción: 1, 2, 3
        assertEquals(3, lista3.getNumElementos());
        IIterador<Integer> iterador3 = lista3.getIterador();
        assertEquals(1, iterador3.next());
        assertEquals(2, iterador3.next());
        assertEquals(3, iterador3.next());



    }

    @Test
    void getNumElementos() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        assertEquals(0, lista.getNumElementos());
        lista.add(1);
        lista.add(2);
        assertEquals(2, lista.getNumElementos());
        lista.delete(1);
        assertEquals(1, lista.getNumElementos());
    }

    @Test
    void getIterador() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        IIterador<Integer> iterador = lista.getIterador();
        assertTrue(iterador.hasNext()); // Debería ser true
        assertEquals(1, iterador.next());
        assertTrue(iterador.hasNext()); // Debería ser true
        assertEquals(2, iterador.next());
        assertTrue(iterador.hasNext()); // Debería ser true
        assertEquals(3, iterador.next());
        assertFalse(iterador.hasNext()); // Debería ser false
    }

    @Test
    void delete() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertTrue(lista.delete(2));
        assertEquals(2, lista.getNumElementos());
        assertFalse(lista.delete(4)); // Intentar eliminar un elemento que no existe

        ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<>();
        lista2.add(1);
        lista2.add(2);
        lista2.add(3);
        assertTrue(lista2.delete(3));
        assertEquals(2, lista2.getNumElementos());
    }




}