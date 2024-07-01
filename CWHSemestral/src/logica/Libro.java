package logica;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int codigo;
    private int anio;
    private String editorial;
    private String idioma;
    private double precio;
    private boolean disponible;

    public Libro(String titulo, String autor, String genero, int codigo, int anio, String editorial, String idioma, double precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.codigo = codigo;
        this.anio = anio;
        this.editorial = editorial;
        this.idioma = idioma;
        this.precio = precio;
        this.disponible = true;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }
    
    public String getGenero() {
        return genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAnio() {
        return anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public Double getPrecio() {
        return precio;
    }
    
    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}
