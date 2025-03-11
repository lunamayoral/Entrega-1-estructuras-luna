import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorDETest {

    @Test
    void insert() {
        //Insertar en una lista vacía
        ListaDoblementeEnlazada<Integer> listaVacia = new ListaDoblementeEnlazada<>();
        IteradorDE<Integer> iteradorVacio = new IteradorDE<>(listaVacia);
        iteradorVacio.insert(1); // Insertar 1 en la lista vacía
        assertEquals(1, listaVacia.cabeza.getDato()); // Verificar que 1 es la cabeza
        assertEquals(1, listaVacia.cola.getDato()); // Verificar que 1 es la cola
        assertEquals(1, listaVacia.getNumElementos()); // Verificar que el número de elementos es 1

        //Insertar en el medio de la lista
        ListaDoblementeEnlazada<Integer> listaMedio = new ListaDoblementeEnlazada<>();
        listaMedio.add(1);
        listaMedio.add(3);
        IteradorDE<Integer> iteradorMedio = new IteradorDE<>(listaMedio);
        iteradorMedio.next(); // Mover al primer elemento (1)
        iteradorMedio.insert(2); // Insertar 2 antes de 3
        assertEquals(2, listaMedio.cabeza.siguiente.getDato()); // Verificar que 2 está entre 1 y 3
        assertEquals(3, listaMedio.cabeza.siguiente.siguiente.getDato()); // Verificar que 3 sigue después de 2
        assertEquals(3, listaMedio.getNumElementos()); // Verificar que el número de elementos es 3
    }


    @Test
    void delete() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        IteradorDE<Integer> iterador = new IteradorDE<>(lista);

        // Eliminar el elemento actual (1)
        iterador.delete();
        assertEquals(2, lista.cabeza.getDato()); // La nueva cabeza debe ser 2
        assertEquals(2, lista.getNumElementos()); // Verificar que el número de elementos es 2
    }

    @Test
    void hasNext() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        IteradorDE<Integer> iterador = new IteradorDE<>(lista);

        assertTrue(iterador.hasNext()); // Debería haber un siguiente (1)
        iterador.next(); // Mover al siguiente (2)
        assertTrue(iterador.hasNext()); // Debería haber un siguiente (2)
        iterador.next(); // Mover al siguiente (3)
        assertTrue(iterador.hasNext()); // Debería haber un siguiente (3)
        iterador.next(); // Mover al siguiente (null)
        assertFalse(iterador.hasNext()); // No debería haber más elementos
    }

    @Test
    void next() {
        // Crear la lista y el iterador
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        IteradorDE<Integer> iterador = new IteradorDE<>(lista);

        assertEquals(1, iterador.next()); // Debería devolver 1
        assertEquals(2, iterador.next()); // Debería devolver 2
        assertEquals(3, iterador.next()); // Debería devolver 3
        assertNull(iterador.next()); // Debería devolver null cuando no hay más elementos

    }

    @Test
    void getDato() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        IteradorDE<Integer> iterador = new IteradorDE<>(lista);

        assertEquals(1, iterador.getDato()); // Debería devolver 1
        iterador.next(); // Mover al siguiente (2)
        assertEquals(2, iterador.getDato()); // Debería devolver 2
        iterador.next(); // Mover al siguiente (3)
        assertEquals(3, iterador.getDato()); // Debería devolver 3
        iterador.next(); // Mover al siguiente (null)
        assertNull(iterador.getDato()); // Debería devolver null cuando no hay más elementos
    }
}