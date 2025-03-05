public class PruebaListaBasica {
    public static void main(String[] args) {
        ListaBasica<String> lista1 = new ListaBasica<String>(5);
        lista1.add("Luna");
        lista1.add("Maria");
        lista1.add("Ana");
        lista1.add("Pedro");
        lista1.add("Juan");
        lista1.add("Alex");
        lista1.mostrarElementos();

        lista1.delete("Ana");
        lista1.mostrarElementos();

        System.out.println("Número de elementos tras borrar: " + lista1.getNumElementos());

    }


}

