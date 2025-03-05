public class IteradorListaBasica<T> implements IIterador<T> {
    private ListaBasica<T> lista;
    private int indiceActual;

    public IteradorListaBasica(ListaBasica<T> lista) {
        this.lista = lista;
        this.indiceActual = 0;
    }

    @Override
    public boolean hasNext(){
        return indiceActual < lista.getNumElementos();
    }

    @Override
    public T next() {
        if(!hasNext()){
            return null;
        }
        return lista.getElemento(indiceActual++);
    }

    @Override
    public void delete(){
        if (indiceActual > 0) {
            lista.delete(lista.getElemento(indiceActual-1));
            indiceActual--;
        }
    }

}
