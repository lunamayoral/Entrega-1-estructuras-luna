public class ListaBasica<T> implements Lista<T> {
    private int numElementos;
    private T[] elementos;
    private int maxElementos;

    // Constructor
    public ListaBasica(int capacidad) {
        this.maxElementos = capacidad;
        this.elementos = (T[])(new Object[this.maxElementos]);
    }

    protected void setElemento(int indice, T elemento) {
        if (indice >= 0 && indice < this.maxElementos) {
            this.elementos[indice] = elemento;
        }else{
            System.out.println("El indice está fuera de rango");
        }
    }

    protected T getElemento(int indice) {
        if (indice >= 0 && indice < this.maxElementos) {
            return this.elementos[indice];
        }
        return null;
    }

    public void mostrarElementos() {
        for (T elemento : this.elementos) {
            if (elemento != null) {
                System.out.println(elemento.toString());
            }
        }
    }

    @Override
    public boolean add(T elemento) {
        if (numElementos < this.maxElementos) {
            this.elementos[numElementos] = elemento;
            numElementos++;
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(T elemento) {
        if (numElementos == 0) {
            return false;
        }
        for (int i = 0; i < numElementos; i++) {
            if (elementos[i] != null && elementos[i].equals(elemento)) {
                for (int j = i; j < numElementos - 1; j++) {
                    elementos[j] = elementos[j + 1];
                }
                elementos[numElementos - 1] = null; // Limpiar el último elemento
                numElementos--; // Decrementar el número de elementos
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumElementos() {
        return numElementos;
    }

    @Override
    public IIterador<T> getIterador() {
        IteradorListaBasica<T> it = new IteradorListaBasica<T>(this);
        return it;
    }



}
