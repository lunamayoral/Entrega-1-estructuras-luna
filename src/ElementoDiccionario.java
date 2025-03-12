public class ElementoDiccionario <K, V> {
    private K clave;
    private V valor;
    protected ElementoDiccionario<K, V> siguiente;
    protected ElementoDiccionario<K, V> anterior;

    public ElementoDiccionario(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }

    public ElementoDiccionario(K clave) {
        this.clave = clave;
        this.valor = null;
        this.siguiente = null;
        this.anterior = null;
    }

    public boolean delete() {
        if (anterior != null) {
            anterior.siguiente = siguiente;
        }
        if (siguiente != null) {
            siguiente.anterior = anterior;
        }
        return true;
    }

    public K getKey() {
        return clave;
    }

    public V getValue() {
        return valor;
    }

    public void setValue(V valor) {
        this.valor = valor;
    }

    public ElementoDiccionario<K, V> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoDiccionario<K, V> siguiente) {
        this.siguiente = siguiente;
    }

    public ElementoDiccionario<K, V> getAnterior() {
        return anterior;
    }

    public void setAnterior(ElementoDiccionario<K, V> anterior) {
        this.anterior = anterior;
    }
}