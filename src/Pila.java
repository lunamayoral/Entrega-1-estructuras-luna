public class Pila<T> {
    private ListaSimplementeEnlazada<T> lista;

    ListaSimplementeEnlazada<T> pila = new ListaSimplementeEnlazada<T>();

    public Pila() {
        lista = new ListaSimplementeEnlazada<T>();
    }

    public void push(T elemento) {
        lista.add(elemento);
    }

    public T pop() {
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
