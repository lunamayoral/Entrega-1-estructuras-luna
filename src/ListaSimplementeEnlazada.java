public class ListaSimplementeEnlazada<T> implements Lista<T> {
    protected ElementoSE<T> cabeza;
    private int numElementos;

    //Constructors
    public ListaSimplementeEnlazada() {
    }

    public ListaSimplementeEnlazada(ElementoSE<T> cabeza) {
        this.cabeza = cabeza;
    }

    @Override
    public boolean add(T dato) {
        ElementoSE<T> temporal = new ElementoSE<T>(dato);
        temporal.setSiguiente(this.cabeza);
        this.cabeza = temporal;
        return true;
    }

    @Override
    public boolean delete(T dato) {
        if (this.cabeza == null) {
            return false;
        }
        if (this.cabeza.equals(dato)) {
            this.cabeza = cabeza.getSiguiente();
            return true;
        }
        ElementoSE<T> actual = this.cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().equals(dato)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public int getNumElementos() {
        if (this.cabeza == null) {
            return 0;
        }
        return numElementos;
    }

    @Override
    public IIterador<T> getIterador() {
        if (this.cabeza == null) {
            return null;
        }
        return new IteradorSE<T>();
    }

    public ElementoSE<T> getCabeza() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza;
    }

    public boolean isEmpty() {
        if (this.cabeza == null) {
            return true;
        }
        return false;
    }

}
