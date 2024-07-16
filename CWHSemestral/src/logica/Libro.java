package logica;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int anio;
    private String idioma;
    private double precio;
    private boolean disponible;

    public Libro(int id, String titulo, String autor, String genero, int anio, String idioma, double precio, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.idioma = idioma;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnio() {
        return anio;
    }

    public String getIdioma() {
        return idioma;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", año=" + anio
                + ", idioma=" + idioma + ", precio=" + precio + ", disponible=" + disponible + "]";
    }
}
