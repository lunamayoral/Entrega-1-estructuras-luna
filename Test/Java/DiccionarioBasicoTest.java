import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioBasicoTest {

    @Test
    void add() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
        assertTrue(diccionario.add("clave1", 1));
        assertTrue(diccionario.add("clave2", 2));
        assertFalse(diccionario.add("clave1", 3)); // No se puede agregar clave duplicada
        assertEquals(3, diccionario.getNumElementos());
    }

    @Test
    void delete() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
        diccionario.add("clave1", 1);
        diccionario.add("clave2", 2);
        assertTrue(diccionario.delete("clave1"));
        assertFalse(diccionario.exists("clave1"));
        assertEquals(2, diccionario.getNumElementos());
        assertFalse(diccionario.delete("clave3")); // Clave no existe
    }

    @Test
    void insert() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
        diccionario.insert("clave1", 1);
        diccionario.insert("clave1", 2); // Debe actualizar el valor
        assertEquals(2, diccionario.getValue("clave1"));
    }

    @Test
    void getKeys() {



    }

    @Test
    void getValues() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);


    }

    @Test
    void find() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
        diccionario.add("clave1", 1);
        IteradorDiccionario<String, Integer> it = diccionario.find("clave1");
        assertNotNull(it.getActual());
        assertEquals("clave1", it.getKey());
    }

    @Test
    void testFind() {

    }

    @Test
    void exists() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
    }

    @Test
    void getValue() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
    }

    @Test
    void setValue() {

    }

    @Test
    void getNumElementos() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
        diccionario.add("clave1", 1);
        diccionario.add("clave2", 2);
        assertEquals(3, diccionario.getNumElementos());
    }

    @Test
    void getIterador() {

    }
}