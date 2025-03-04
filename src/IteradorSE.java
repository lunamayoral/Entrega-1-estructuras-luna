public class IteradorSE<T> implements IIterador<T> {
    // Atributos de la clase iterador
    private ListaSimplementeEnlazada<T> miLista;
    private ElementoSE<T> actual;

    // Constructor
    public IteradorSE(ListaSimplementeEnlazada<T> l) {
        this.miLista = l;
        this.actual = l.cabeza;
    }
    public IteradorSE() {
        this.miLista = new ListaSimplementeEnlazada<T>();
    }

    @Override
    public boolean hasNext() {
        return this.actual != null;
    }

    @Override
    public T getDato() {
        T temporal = this.actual.getDato(); //elemento, le pido el dato y lo guardo en la variable temporal
        this.actual = this.actual.getSiguiente();
        return temporal;
    }

    @Override
    public T next() {
        T temporal = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return temporal;
    }

    @Override
    public void delete(){ // POR ACABAR
        this.actual = null;
    }

}
