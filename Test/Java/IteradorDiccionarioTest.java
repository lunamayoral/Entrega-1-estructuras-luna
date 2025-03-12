import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorDiccionarioTest {

    @Test
    void hasNext() {
    }

    @Test
    void next() {

    }

    @Test
    void getKey() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
        assertEquals("elemento", elemento.getKey());

    }

    @Test
    void getValue() {

    }

    @Test
    void getActual() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico(elemento);
        IteradorDiccionario<String, Integer> it = new IteradorDiccionario<>();
        assertEquals(cew, diccionario.getActual());
    }

    @Test
    void delete() {
    }
}