public class IteradorDE<T> implements IIterador<T> {
    private ListaDoblementeEnlazada<T> lista;
    private ElementoDE<T> actual;

    public IteradorDE(ListaDoblementeEnlazada<T> lista) {
        this.lista = lista;
        this.actual = lista.cabeza;
    }

    public void insert(T dato) {
        if (actual == null) {
            // Si actual es null, significa que estamos al final de la lista
            this.lista.add(dato); // Agregar al final
        } else {
            this.lista.insert(this.actual, dato); // Insertar antes del elemento actual
        }
    }

    @Override
    public void delete() {
        if (actual != null) {
            this.lista.delete(this.actual.getDato());
        }
    }

    @Override
    public boolean hasNext() {
        return this.actual != null;
    }

    @Override
    public T next() {
        if (actual == null) {
            System.out.println("No hay elementos en la lista");
            return null;

        }
        T temporal = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return temporal;
    }

    public T getDato() {
        if (actual == null) {
            return null; // Devuelve null si no hay más elementos
        }
        return this.actual.getDato();
    }
}
