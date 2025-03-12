import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoDiccionarioTest {


    @Test
    void delete() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 120);
        ElementoDiccionario<String, Integer> elementoAnterior = new ElementoDiccionario<>("anterior", 456);
        ElementoDiccionario<String, Integer> elementoSiguiente = new ElementoDiccionario<>("siguiente", 789);
        elemento.anterior = elementoAnterior;
        elemento.siguiente = elementoSiguiente;
        elementoAnterior.siguiente = elemento;
        elementoSiguiente.anterior = elemento;
        assertTrue(elemento.delete());
        assertTrue(elementoAnterior.siguiente==elementoSiguiente);
        assertNull(elementoAnterior.anterior);
        assertNull(elementoSiguiente.siguiente);
        assertTrue(elementoSiguiente.delete());
        assertTrue(elementoAnterior.delete());
        elementoSiguiente=null;
        elementoAnterior=null;
        assertTrue(elementoSiguiente==null);
        assertTrue(elementoAnterior==null);
    }

    @Test
    void getKey() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento");
        assertEquals("elemento", elemento.getKey());


    }

    @Test
    void getValue() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 120);
        assertEquals(120, elemento.getValue());

    }

    @Test
    void setValue() {
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 120);
        elemento.setValue(230);
        assertEquals(230, elemento.getValue());

    }

    @Test
    void getAnterior(){
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 120);
        assertNull(elemento.getAnterior());
    }

    @Test
    void getSiguiente(){
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 120);
        assertNull(elemento.getSiguiente());
    }

    @Test
    void setAnterior(){
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 120);
        ElementoDiccionario<String, Integer> elemento1 = new ElementoDiccionario<>("elemento1", 12);
        elemento.setAnterior(elemento1);
        assertEquals(elemento1,elemento.getAnterior());
    }

    @Test
    void setSiguiente(){
        ElementoDiccionario<String, Integer> elemento = new ElementoDiccionario<>("elemento", 120);
        ElementoDiccionario<String, Integer> elemento1 = new ElementoDiccionario<>("elemento1", 12);
        elemento.setSiguiente(elemento1);
        assertEquals(elemento1,elemento.getSiguiente());
    }
}