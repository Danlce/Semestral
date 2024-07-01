package logica;

import grafica.BibliotecaGUI;

public class Main {
    public static void main(String[] args) {
        BibliotecaGUI biblioteca = new BibliotecaGUI();

        // Ejemplo de creación de libros y clientes
        Libro libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", "Fantasia", 0001, 1954, "Editorial Tirant Lo Blanch", "inglés", 24.99);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 0002, 1967, "Editorial Sudamericana", "español", 19.99);

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

        // Mostrar información de los libros
        System.out.println("Libros en la biblioteca:");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
    }
}
