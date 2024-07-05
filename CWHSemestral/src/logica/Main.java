package logica;

import grafica.BibliotecaGUI;

public class Main {
    public static void main(String[] args) {
        BibliotecaGUI biblioteca = new BibliotecaGUI();

        // Ejemplo de creación de libros y clientes
        

        Cliente cliente1 = new Cliente("Juan Pérez", 1001);
        Cliente cliente2 = new Cliente("María Gómez", 1002);

        // Agregar libros y clientes a la biblioteca
       

        biblioteca.agregarCliente(cliente1);
        biblioteca.agregarCliente(cliente2);

        // Ejemplo de registro de alquiler
       
      
    }
}
