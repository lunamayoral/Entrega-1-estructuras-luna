package P1ListasBasicas;

public class ListaBasica<TipoElemento> {
    private int N_elementos;
    private TipoElemento[] arrayDatos;
    private int T_max;

    public ListaBasica(int capacidad) {
        this.T_max = capacidad;
        this.arrayDatos = (TipoElemento[])(new Object[this.T_max]);
    }

    public void setElemento(int indice, TipoElemento elemento) {
        if (indice >= 0 && indice < this.T_max) {
            this.arrayDatos[indice] = elemento;
        }else{
            System.out.println("El indice está fuera de rango");
        }
    }

    public TipoElemento getElemento(int indice) {
        return (TipoElemento)(indice >= 0 && indice < this.T_max ? this.arrayDatos[indice] : null);
    }

    public void mostrarElementos() {
        for (TipoElemento elemento : this.arrayDatos) {
            if (elemento != null) {
                System.out.println(elemento.toString());
            }
        }
    }

}
