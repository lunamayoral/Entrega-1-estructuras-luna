public class ListaDoblementeEnlazada<T> implements Lista<T> {
    private ElementoDE<T> cabeza;
    private ElementoDE<T> cola;
    private int numElementos;

    @Override
    public boolean add(T dato) {
        ElementoDE<T> elemento = new ElementoDE<T>(dato);
        if(this.cabeza == null) {
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
            ElementoDE<T> nuevoElemento = new ElementoDE<T>(dato);
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

    @Override
    public int getNumElementos() {
        if (this.cabeza == null) {
            return 0;
        }
        return this.numElementos;
    }

    @Override
    public IIterador<T> getIterador() {
        if (this.cabeza == null) {
            return null;
        }
        return new IteradorDE<T>();
    }

    @Override
    public boolean delete(T dato) {   //PREGUNTAR!!!!!
        return false;
    }

}
