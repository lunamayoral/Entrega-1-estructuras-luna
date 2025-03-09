public class IteradorDE<T> implements IIterador<T> {
    private ListaDoblementeEnlazada<T> lista;
    private ElementoDE<T> actual;

    public IteradorDE(ListaDoblementeEnlazada<T> lista) {
        this.lista = lista;
    }

    public IteradorDE() {
        this.lista = new ListaDoblementeEnlazada<>();
    }


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
        if (!hasNext()) {
            System.out.println("No hay elementos en la lista");
        }
        T temporal = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return temporal;
    }

    public T getDato() {
        T temporal = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return temporal;
    }
}
