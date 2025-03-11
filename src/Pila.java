public class Pila<T> {
    private ListaSimplementeEnlazada<T> pila;

    public Pila() {
        pila = new ListaSimplementeEnlazada<T>();
    }

    public void push(T elemento) {
        pila.add(elemento);
    }

    public T pop() {
        if (pila.isEmpty()) {
            return null;
        } else {
            T elemento = pila.getCabeza().getDato();
            pila.delete(elemento);
            return elemento;
        }
    }

    public T peek() {
        if (pila.isEmpty()) {
            return null;
        } else {
            return pila.getCabeza().getDato();
        }
    }

    public boolean vacia() {
        return pila.isEmpty();
    }

    public int size() {
        return pila.getNumElementos();
    }

}
