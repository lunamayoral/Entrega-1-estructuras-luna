import java.util.Comparator;
public class DiccionarioOrdenado<K extends Comparable<K>,V> extends DiccionarioBasico<K,V> {
    private OrdenadorDiccionario<K, V> ordenador;

    public DiccionarioOrdenado(boolean ordenAscendente) {
        this.ordenador = new OrdenadorDiccionario<>(ordenAscendente);
    }

    public OrdenadorDiccionario<K, V> getOrdenador() {
        return ordenador;
    }

    @Override
    public boolean add(K clave, V valor) {
        ElementoDiccionario<K, V> nuevoElemento = new ElementoDiccionario<>(clave, valor);
        if (getCabeza() == null) {
            setCabeza(nuevoElemento);
            setCola(nuevoElemento);
            return true;
        }
        Comparator<K> comparador;
        if (ordenador.getOrdenAscendente()) {
            comparador = Comparator.naturalOrder();
        } else {
            comparador = Comparator.reverseOrder();
        }
        ElementoDiccionario<K, V> actual = getCabeza();
        ElementoDiccionario<K, V> previo = null;
        while (actual != null && comparador.compare(actual.getKey(), clave) < 0) {
            previo = actual;
            actual = actual.getSiguiente();
        }
        if(previo==null){
            nuevoElemento.setSiguiente(getCabeza());
            getCabeza().setAnterior(nuevoElemento);
            setCabeza(nuevoElemento);
        } else if (actual==null) {
            previo.setSiguiente(nuevoElemento);
            nuevoElemento.setAnterior(previo);
            setCola(nuevoElemento);
        }else{
            previo.setSiguiente(nuevoElemento);
            nuevoElemento.setAnterior(previo);
            nuevoElemento.setSiguiente(actual);
            actual.setAnterior(nuevoElemento);
        }
        return true;
    }
}