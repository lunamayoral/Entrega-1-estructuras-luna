import java.util.NoSuchElementException;

public class IteradorDiccionario<K, V> implements IIterador<ElementoDiccionario<K,V>> {
    private Diccionario<K, V> miDiccionario;
    private ElementoDiccionario<K, V> actual;

    public IteradorDiccionario(ElementoDiccionario<K, V> cabeza) {
        this.actual = cabeza;
    }

    public IteradorDiccionario() {
        this.actual = null;

    }

    @Override
    public boolean hasNext() {
        return actual != null && actual.siguiente != null;
    }

    @Override
    public ElementoDiccionario<K, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más elementos en el diccionario");
        }
        ElementoDiccionario<K, V> elementoActual = actual; // Guarda el elemento actual
        actual = actual.siguiente; // Avanza al siguiente
        return elementoActual; // Devuelve el elemento actual
    }

    public K getKey() {
        if (actual != null) {
            return actual.getKey();
        }
        return null;
    }

    public V getValue() {
        if (actual != null) {
            return actual.getValue();
        }
        return null;
    }

    protected ElementoDiccionario<K, V> getActual() {
        return actual;
    }

    @Override
    public void delete() {
        this.miDiccionario.delete(this.actual.getKey());
    }

    public void setActual(ElementoDiccionario<K, V> nuevoActual) {
        this.actual = nuevoActual; // Establece el nuevo elemento actual
    }
}
