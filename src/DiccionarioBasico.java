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
        if (it.getActual() != null) {
            it.getActual().setValue(valor);
        } else {
            this.add(clave, valor);
        }
        return true;
    }

    public ListaDoblementeEnlazada<K> getKeys() {
        IIterador<ElementoDiccionario<K, V>> it = this.getIterador();
        ListaDoblementeEnlazada<K> claves = new ListaDoblementeEnlazada<>();
        while (it.hasNext()) {
            ElementoDiccionario<K, V> elemento = it.next();
            claves.add(elemento.getKey());
        }
        return claves;
    }

    public ListaDoblementeEnlazada<V> getValues() {
        IIterador<ElementoDiccionario<K, V>> it = this.getIterador();
        ListaDoblementeEnlazada<V> valores = new ListaDoblementeEnlazada<>();
        while (it.hasNext()) {
            ElementoDiccionario<K, V> elemento = it.next();
            valores.add(elemento.getValue());
        }
        return valores;

    }

    public IteradorDiccionario<K, V> find (IteradorDiccionario<K, V> it, K clave) {
        while (it.hasNext()) {
            it.next();
            if (it.getKey().equals(clave)) {
                return it;
            }
        }
        return it;
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
        IteradorDiccionario<K, V> it = this.find(clave);
        return it.getActual() != null;
    }

    @Override
    public V getValue(K clave) {
        return this.find(clave).getValue();
    }

    public boolean setValue(K clave, V valor) {
        IteradorDiccionario<K, V> it = this.find(clave); // Buscamos el elemento que corresponde a la clave
        if (it.getActual() != null) { // si hay elemento
            it.getActual().setValue(valor); // actualizamos el valor
            return true; // indicacion operacion exitosa
        }
        return false;  // La clave no existe, no puedo actualizar
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
    public IIterador<ElementoDiccionario<K,V>> getIterador() {
        return new IteradorDiccionario<>();
    }



}
