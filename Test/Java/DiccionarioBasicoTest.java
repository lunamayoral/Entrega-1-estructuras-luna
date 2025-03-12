import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiccionarioBasicoTest {

    @Test
    void add() {
        ElementoDiccionario<String,Integer> elemento1 = new ElementoDiccionario<>("elemento",6);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento1);
        assertTrue(diccionario.add("clave1", 1));
        assertTrue(diccionario.add("clave2", 2));
        assertFalse(diccionario.add("clave1", 3)); // No se puede agregar clave duplicada
        assertEquals(3, diccionario.getNumElementos());
    }

    @Test
    void delete() {
    }

    @Test
    void insert() {
    }

    @Test
    void getKeys() {
    }

    @Test
    void getValues() {
    }

    @Test
    void find() {
    }

    @Test
    void testFind() {
    }

    @Test
    void exists() {
    }

    @Test
    void getValue() {
    }

    @Test
    void setValue() {
    }

    @Test
    void getNumElementos() {
    }

    @Test
    void getIterador() {
    }
}