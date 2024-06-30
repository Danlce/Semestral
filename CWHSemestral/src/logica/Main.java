package logica;

import grafica.BibliotecaGUI;

public class Main {
    public static void main(String[] args) {
        BibliotecaGUI biblioteca = new BibliotecaGUI();

        // Ejemplo de creación de libros y clientes
        Libro libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez");

        Cliente cliente1 = new Cliente("Juan Pérez", 1001);
        Cliente cliente2 = new Cliente("María Gómez", 1002);

        // Agregar libros y clientes a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        biblioteca.agregarCliente(cliente1);
        biblioteca.agregarCliente(cliente2);

        // Ejemplo de registro de alquiler
        Alquiler registro1 = new Alquiler(libro1, cliente1);
        Alquiler registro2 = new Alquiler(libro2, cliente2);

        biblioteca.agregarAlquiler(registro1);
        biblioteca.agregarAlquiler(registro2);
    }
}
