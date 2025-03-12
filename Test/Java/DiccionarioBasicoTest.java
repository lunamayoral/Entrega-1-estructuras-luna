import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioBasicoTest {

    @Test
    void add() {
        DiccionarioBasico<String, String> diccionariovacio = new DiccionarioBasico<>();
        assertTrue(diccionariovacio.add("clave1", "valor1"));
        assertEquals(1, diccionariovacio.getNumElementos());
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico<>(elemento);
        assertTrue(diccionario.add("clave1", 1));
        assertTrue(diccionario.add("clave2", 2));
        assertFalse(diccionario.add("clave1", 3)); // No se puede agregar clave duplicada
        assertEquals(3, diccionario.getNumElementos());
    }

    @Test
    void delete() {
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>();
        diccionario.add("clave1", 1);
        diccionario.add("clave2", 2);
        diccionario.add("clave3", 3);

        // Eliminar un elemento existente
        assertTrue(diccionario.delete("clave1"));
        assertFalse(diccionario.exists("clave1"));
        assertEquals(2, diccionario.getNumElementos());

        // Intentar eliminar un elemento que no existe
        assertFalse(diccionario.delete("clave4"));

        // Eliminar el último elemento
        assertTrue(diccionario.delete("clave2"));
        assertFalse(diccionario.exists("clave2"));
        assertEquals(1, diccionario.getNumElementos());

        // Eliminar el último elemento restante
        assertTrue(diccionario.delete("clave3"));
        assertFalse(diccionario.exists("clave3"));
        assertEquals(0, diccionario.getNumElementos());

        // Intentar eliminar de un diccionario vacío
        assertFalse(diccionario.delete("clave1"));

        DiccionarioBasico<String, Integer> diccionario2 = new DiccionarioBasico<>();
        diccionario2.add("clave1", 1); // Primer elemento
        diccionario2.add("clave2", 2); // Elemento a eliminar (medio)
        diccionario2.add("clave3", 3); // Último elemento

        // Verifica que el diccionario tenga 3 elementos
        assertEquals(3, diccionario2.getNumElementos());

        // Eliminar el elemento del medio
        assertTrue(diccionario2.delete("clave2"));
        assertFalse(diccionario2.exists("clave2"));
        assertEquals(2, diccionario2.getNumElementos());

        // Verifica que los elementos restantes estén conectados correctamente
        assertTrue(diccionario2.exists("clave1"));
        assertTrue(diccionario2.exists("clave3"));
    }

    @Test
    void insert() {
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>();
        // Insertar un nuevo elemento
        diccionario.insert("clave1", 1);
        assertTrue(diccionario.exists("clave1"));
        assertEquals(1, diccionario.getValue("clave1"));
        // Actualizar el valor de un elemento existente
        diccionario.insert("clave1", 2);
        assertTrue(diccionario.exists("clave1"));
        assertEquals(2, diccionario.getValue("clave1"));
    }

    @Test
    void getKeys() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave1", 1);
        diccionario.add("clave2", 2);
        ListaDoblementeEnlazada<String> claves = diccionario.getKeys();
        assertEquals(2, claves.getNumElementos());
    }

    @Test
    void getValues() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave1", 1);
        diccionario.add("clave2", 2);
        ListaDoblementeEnlazada<Integer> valores = diccionario.getValues();
        assertEquals(2, valores.getNumElementos());
    }

    @Test
    void find() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave1", 1);
        IteradorDiccionario<String, Integer> it = diccionario.find("clave1");
        assertNotNull(it.getActual());
        assertEquals("clave1", it.getKey());

        DiccionarioBasico<String, Integer> diccionario2 = new DiccionarioBasico<>();
        diccionario2.add("clave1", 1);
        diccionario2.add("clave2", 2);
        diccionario2.add("clave3", 3);

        // Buscar una clave que existe
        IteradorDiccionario<String, Integer> resultado = diccionario2.find("clave2");
        assertFalse(resultado.hasNext());


    }


    @Test
    void exists() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave1", 1);
        assertTrue(diccionario.exists("clave1"));
        assertFalse(diccionario.exists("clave2"));
    }

    @Test
    void getValue() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave1", 1);
        assertEquals(1, diccionario.getValue("clave1"));
    }

    @Test
    void setValue() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave1", 1);
        assertTrue(diccionario.setValue("clave1", 2)); // Debe actualizar el valor
        assertEquals(2, diccionario.getValue("clave1"));
        assertFalse(diccionario.setValue("clave2", 3));

    }

    @Test
    void getNumElementos() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave1", 1);
        diccionario.add("clave2", 2);
        assertEquals(3, diccionario.getNumElementos());
    }

    @Test
    void getIterador() {
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>();
        diccionario.add("clave1", 1);
        diccionario.add("clave2", 2);
        IteradorDiccionario<String, Integer> iterador = diccionario.getIterador();
        assertTrue(iterador.hasNext());
    }

    @Test
    void getCabeza() {
        ElementoDiccionario<String,Integer> cabeza = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(cabeza);
        assertEquals(cabeza, diccionario.getCabeza());
    }
}