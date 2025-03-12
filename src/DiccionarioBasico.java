public class DiccionarioBasico<K, V> implements Diccionario<K, V> {
    private ElementoDiccionario<K, V> cabeza;
    private ElementoDiccionario<K, V> cola;

    public DiccionarioBasico(ElementoDiccionario<K, V> elemento) {
        this.cabeza = elemento;
        this.cola = elemento;
    }

    public DiccionarioBasico() {
        this.cabeza = null;
        this.cola = null;
    }

    public ElementoDiccionario<K, V> getCabeza() {
        return cabeza;
    }

    @Override
    public boolean add(K clave, V valor) {
        if (exists(clave)) {
            return false;
        }
        ElementoDiccionario<K, V> nuevoElemento = new ElementoDiccionario<>(clave, valor);
        if (cabeza == null) {
            cabeza = nuevoElemento;
            cola = nuevoElemento;
        } else {
            cola.siguiente = nuevoElemento;
            nuevoElemento.anterior = cola;
            cola = nuevoElemento;
        }
        return true;
    }

    @Override
    public boolean delete(K clave) {
        ElementoDiccionario<K, V> actual = cabeza;
        while (actual != null) {
            if (actual.getKey().equals(clave)) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }
                return true;
            }
            actual = actual.siguiente;
        }
        return false; // no se encontró la clave
    }

    public boolean insert(K clave, V valor) {
        IteradorDiccionario<K, V> it = this.find(clave);
        if (it != null && it.getActual() != null) {
            it.getActual().setValue(valor);
        } else {
            this.add(clave, valor);
        }
        return true;
    }

    public ListaDoblementeEnlazada<K> getKeys() {
        IteradorDiccionario<K, V> it = this.getIterador();
        ListaDoblementeEnlazada<K> claves = new ListaDoblementeEnlazada<>();
        while (it.hasNext()) {
            ElementoDiccionario<K, V> elemento = it.next(); // Obtiene el elemento actual
            claves.add(elemento.getKey());
        }
        return claves;
    }

    public ListaDoblementeEnlazada<V> getValues() {
        IteradorDiccionario<K, V> it = this.getIterador();
        ListaDoblementeEnlazada<V> valores = new ListaDoblementeEnlazada<>();
        while (it.hasNext()) {
            it.next();
            valores.add(it.getValue());
        }
        return valores;

    }

    protected IteradorDiccionario<K, V> find (K clave) {
        IteradorDiccionario<K, V> it = new IteradorDiccionario<>(cabeza);
        while (it.hasNext()) {
            ElementoDiccionario<K, V> elemento = it.next();
            if (elemento != null && elemento.getKey().equals(clave)) {
                return it;
            }
        }
        return it;
    }

    @Override
    public boolean exists(K clave) {
        ElementoDiccionario<K, V> actual = cabeza; // Comienza desde la cabeza
        while (actual != null) { // Recorre la lista hasta que no haya más elementos
            if (actual.getKey().equals(clave)) { // Compara la clave
                return true; // La clave existe
            }
            actual = actual.siguiente; // Avanza al siguiente elemento
        }
        return false; // La clave no existe
    }

    @Override
    public V getValue(K clave) {
        return this.find(clave).getValue();
    }

    public boolean setValue(K clave, V valor) {
        ElementoDiccionario<K, V> actual = cabeza;
        while (actual != null) {
            if (actual.getKey().equals(clave)) {
                actual.setValue(valor); // Actualiza el valor
                return true; // Indica que la operación fue exitosa
            }
            actual = actual.siguiente;
        }
        return false; // La clave no existe, no se puede actualizar
    }

    @Override
    public int getNumElementos() {
        int cont = 0;
        ElementoDiccionario<K, V> actual = cabeza;
        while (actual != null) {
            cont++;
            actual = actual.siguiente;
        }
        return cont;
    }

    @Override
    public IteradorDiccionario<K, V> getIterador() {
        return new IteradorDiccionario<>(cabeza);
    }

}
