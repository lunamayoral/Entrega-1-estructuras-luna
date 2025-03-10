public class IteradorDiccionario<K, V> implements IIterador<ElementoDiccionario<K,V>> {
    private Diccionario<K, V> miDiccionario;
    private ElementoDiccionario<K, V> actual;

    public IteradorDiccionario(ElementoDiccionario<K, V> cabeza) {
        this.actual = cabeza;
    }

    public IteradorDiccionario() {

    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public ElementoDiccionario<K, V> next() {
        if (!hasNext()) {
            System.out.println("No hay elementos en el diccionario");
            return null;
        }
        ElementoDiccionario<K, V> elemento = actual;
        actual = actual.siguiente;
        return actual;
    }

    public K getKey() {
        if (actual != null) {
            return actual.getKey();
        }
        return null;
    }

    public V getValue() {
        return actual.getValue();
    }

    protected ElementoDiccionario<K, V> getActual() {
        return actual;
    }

    @Override
    public void delete() {
        this.miDiccionario.delete(this.actual.getKey());
    }
}
