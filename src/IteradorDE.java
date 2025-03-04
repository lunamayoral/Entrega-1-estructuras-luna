public class IteradorDE<T> implements IIterador<T> {

    private ListaDoblementeEnlazada<T> lista;
    private ElementoDE<T> actual;

    public void insert(T dato) {
        this.lista.insert(this.actual, dato);
    }

    @Override
    public void delete() {
        this.lista.delete(this.actual);
    }

    @Override
    public boolean hasNext() {
        return this.actual != null;
    }

    @Override
    public T next() {
        T temporal = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return temporal;
    }

    @Override
    public T getDato() {
        T temporal = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return temporal;
    }
}
