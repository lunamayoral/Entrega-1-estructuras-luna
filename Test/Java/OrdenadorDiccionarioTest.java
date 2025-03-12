import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdenadorDiccionarioTest {

    @Test
    void getOrdenAscendente() {
        OrdenadorDiccionario<String, Integer> ordenador1= new OrdenadorDiccionario<>(true);
        assertTrue(ordenador1.getOrdenAscendente());
    }

    @Test
    void setOrdenAscendente() {
        OrdenadorDiccionario<String, Integer> ordenador1= new OrdenadorDiccionario<>();
        ordenador1.setOrdenAscendente(false);
        assertFalse(ordenador1.getOrdenAscendente());

    }
}