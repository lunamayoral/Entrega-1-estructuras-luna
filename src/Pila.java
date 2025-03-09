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
            T elemento = pila.getUltimo().getDato();
            pila.delete(elemento);
            return elemento;
        }
    }

}
