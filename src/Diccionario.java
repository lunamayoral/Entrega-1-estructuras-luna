public interface Diccionario <K, V> {
    boolean add (K clave, V valor);
    boolean delete (K clave);
    IIterador<ElementoDiccionario<K,V>> getIterador ();
    boolean exists(K clave);
    V getValue(K clave);
    int getNumElementos();
}
