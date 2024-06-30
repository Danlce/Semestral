package logica;

public class Alquiler {
    private Libro libro;
    private Cliente cliente;

    public Alquiler(Libro libro, Cliente cliente) {
        this.libro = libro;
        this.cliente = cliente;
    }

    // Getters
    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
