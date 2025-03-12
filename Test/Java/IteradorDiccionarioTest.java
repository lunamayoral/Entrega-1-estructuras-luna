import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IteradorDiccionarioTest {

    @Test
    void hasNext() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elem", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        IteradorDiccionario<String, Integer> it = new IteradorDiccionario<>(elemento);
        assertFalse(it.hasNext());
        diccionario.add("clave",12);
        assertTrue(it.hasNext());
    }

    @Test
    void next() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elem", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave",12);
        IteradorDiccionario<String, Integer> it = new IteradorDiccionario<>(elemento);
        assertEquals("elem",it.next().getKey());
        try {
            it.next();
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    @Test
    void getKey() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico<>(elemento);
        IteradorDiccionario<String, Integer> it = diccionario.getIterador();
        assertEquals("elemento", it.getKey());
        IteradorDiccionario<String, Integer> it2 = new IteradorDiccionario<>();
        assertNull(it2.getKey());
    }

    @Test
    void getValue() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elem", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        IteradorDiccionario<String, Integer> it = diccionario.getIterador();
        assertEquals(5,it.getValue());
        IteradorDiccionario<String, Integer> it2 = new IteradorDiccionario<>();
        assertNull(it2.getValue());
    }

    @Test
    void getActual() {
        ElementoDiccionario<String,Integer> elemento = new ElementoDiccionario<>("elemento",5);
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico<>(elemento);
        IteradorDiccionario<String, Integer> it = diccionario.getIterador();
        assertEquals(elemento, it.getActual());
    }

    @Test
    void delete() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elem", 5);
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>(elemento);
        diccionario.add("clave",12);
        IteradorDiccionario<String, Integer> it = new IteradorDiccionario<>(diccionario);
        it.next();
        it.delete();
        assertEquals("elem", it.getActual().getKey());
        assertEquals(5, it.getActual().getValue());
    }
}