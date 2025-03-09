public class Cola<T> {
    private ListaSimplementeEnlazada<T> cola;

    public Cola() {
        cola = new ListaSimplementeEnlazada<T>();
    }

    public void enqueue(T elemento) {
        cola.add(elemento);
    }

    public T dequeue() {
        if (cola.isEmpty()) {
            return null;
        } else {
            T elemento = cola.getUltimo().getDato();
            cola.delete(elemento);
            return elemento;
        }
    }

}
