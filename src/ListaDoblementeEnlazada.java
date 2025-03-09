public class ListaDoblementeEnlazada<T> implements Lista<T> {
    private ElementoDE<T> cabeza;
    private ElementoDE<T> cola;

    public ListaDoblementeEnlazada(ElementoDE<T> cabeza) {
        this.cabeza = cabeza;
    }

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
                nuevoElemento.anterior.siguiente = nuevoElemento;
                nuevoElemento.siguiente.anterior = nuevoElemento;
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
        if (this.cabeza == null) {
            return null;
        }
        return new IteradorDE<>();
    }

    @Override
    public boolean delete(T dato) {
        ElementoDE<T> elemento = this.cabeza;
        if (elemento != null) {
            if (elemento.getDato().equals(dato)) {
                delete(elemento);
                return true; // Elemento encontrado y eliminado
            }
            elemento = elemento.siguiente;
        }
        return false; // Elemento no encontrado
    }


    public void delete(ElementoDE<T> elemento) {
        if (elemento != null) {
            boolean cabeza = false;
            boolean cola = false;

            if (elemento.anterior == null) {
                this.cabeza = elemento.siguiente;
                cabeza = true;
            }
            if(elemento.siguiente == null) {
                this.cola = elemento.anterior;
                cola = true;
            }
            if(!cabeza) {
                elemento.anterior.siguiente = elemento.siguiente;
            }
            if(!cola) {
                elemento.siguiente.anterior = elemento.anterior;
            }
        }
    }

}
