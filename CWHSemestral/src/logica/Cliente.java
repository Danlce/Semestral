package logica;

public class Cliente {
    private String nombre;
    private int codigo;

    public Cliente(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
}
