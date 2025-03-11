public class ListaDoblementeEnlazada<T> implements Lista<T> {
    protected ElementoDE<T> cabeza;
    protected ElementoDE<T> cola;

    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    @Override
    public boolean add(T dato) {
        ElementoDE<T> elemento = new ElementoDE<>(dato);
        if (this.cabeza == null) {
            this.cabeza = elemento;
            this.cola = elemento;
        } else {
            elemento.anterior = this.cola;
            this.cola.siguiente = elemento;
            this.cola = elemento;
        }
        return true;
    }

    protected void insert(ElementoDE<T> elemento, T dato) {
        if (elemento == null) {
            this.add(dato);
        } else {
            ElementoDE<T> nuevoElemento = new ElementoDE<>(dato);
            if (elemento == this.cabeza) {
                elemento.anterior = nuevoElemento;
                nuevoElemento.siguiente = elemento;
                this.cabeza = nuevoElemento;
            } else {
                nuevoElemento.siguiente = elemento;
                nuevoElemento.anterior = elemento.anterior;
                elemento.anterior.siguiente = nuevoElemento;
                elemento.anterior = nuevoElemento;
            }
        }
    }


    @Override
    public int getNumElementos() {
        int contador = 0;
        ElementoDE<T> actual = this.cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public IIterador<T> getIterador() {
        return new IteradorDE<>(this);
    }

    @Override
    public boolean delete(T dato) {
        ElementoDE<T> actual = this.cabeza;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                // Si se encuentra el elemento, proceder a eliminarlo
                if (actual.anterior == null) { // Es la cabeza
                    this.cabeza = actual.siguiente;
                    if (this.cabeza != null) {
                        this.cabeza.anterior = null; // Actualiza la cabeza
                    }
                } else {
                    actual.anterior.siguiente = actual.siguiente; // Conectar anterior con siguiente
                }

                if (actual.siguiente == null) { // Es la cola
                    this.cola = actual.anterior;
                    if (this.cola != null) {
                        this.cola.siguiente = null; // Actualiza la cola
                    }
                } else {
                    actual.siguiente.anterior = actual.anterior; // Conectar siguiente con anterior
                }
                return true; // Elemento encontrado y eliminado
            }
            actual = actual.siguiente; // Avanzar al siguiente elemento
        }
        return false; // Elemento no encontrado
    }

}
