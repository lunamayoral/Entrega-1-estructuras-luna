public class Pila<T> {
    private ListaSimplementeEnlazada<T> lista;

    ListaSimplementeEnlazada<T> pila = new ListaSimplementeEnlazada<T>();

    public void push(T elemento) {
        lista.add(elemento);
    }

    // public T pop() {}

}
