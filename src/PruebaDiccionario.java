public class PruebaDiccionario {
    public static void main(String[] args) {
        // Crear una instancia del diccionario
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>();

        // Agregar elementos al diccionario
        System.out.println("Agregando elementos:");
        diccionario.add("uno", 1);
        diccionario.add("dos", 2);
        diccionario.add("tres", 3);

        // Mostrar claves y valores
        System.out.println("Claves: " + diccionario.getKeys());
        System.out.println("Valores: " + diccionario.getValues());

        // Verificar si una clave existe
        System.out.println("¿Existe la clave 'dos'? " + diccionario.exists("dos"));
        System.out.println("¿Existe la clave 'cuatro'? " + diccionario.exists("cuatro"));

        // Obtener un valor
        System.out.println("Valor de 'tres': " + diccionario.getValue("tres"));

        // Actualizar un valor
        System.out.println("Actualizando el valor de 'dos' a 22.");
        diccionario.setValue("dos", 22);
        System.out.println("Valor actualizado de 'dos': " + diccionario.getValue("dos"));

        // Eliminar un elemento
        System.out.println("Eliminando la clave 'uno'.");
        diccionario.delete("uno");
        System.out.println("Claves después de eliminar 'uno': " + diccionario.getKeys());

        // Contar elementos
        System.out.println("Número de elementos en el diccionario: " + diccionario.getNumElementos());

        // Intentar eliminar una clave que no existe
        System.out.println("Intentando eliminar la clave 'cuatro': " + diccionario.delete("cuatro"));
        System.out.println("Número de elementos después de intentar eliminar 'cuatro': " + diccionario.getNumElementos());
    }

}
