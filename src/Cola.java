public class Cola<T> {
    private ListaSimplementeEnlazada<T> cola;

    public Cola() {
        cola = new ListaSimplementeEnlazada<T>();
    }

    public void enqueue(T elemento) {
        // Si la cola está vacía, simplemente agrega el elemento
        if (cola.isEmpty()) {
            cola.add(elemento);
        } else {
            // Si no está vacía, obtenemos el último elemento y lo enlazamos
            ElementoSE<T> nuevoElemento = new ElementoSE<>(elemento);
            ElementoSE<T> ultimo = cola.getUltimo();
            ultimo.setSiguiente(nuevoElemento);
        }
    }

    public T dequeue() {
        if (cola.isEmpty()) {
            return null;
        } else {
            T elemento = cola.getCabeza().getDato();
            cola.delete(elemento);
            return elemento;
        }
    }

    public boolean vacia() {
        return cola.isEmpty();
    }

    public int size() {
        return cola.getNumElementos();
    }

    public T peek() {
        if (cola.isEmpty()) {
            return null;
        } else {
            return cola.getCabeza().getDato();
        }
    }

}
