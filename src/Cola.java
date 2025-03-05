public class Cola<T> {
    private ListaSimplementeEnlazada<T> lista;

    public Cola() {
        lista = new ListaSimplementeEnlazada<T>();
    }

    public void enqueue(T elemento) {
        lista.add(elemento);
    }

    public T dequeue() {
        if (lista.isEmpty()) {
            return null;
        } else {
            T elemento = lista.getCabeza().getDato();
            lista.delete(elemento);
            return elemento;
        }
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

}
