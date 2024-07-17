package logica;

import java.sql.Date;

public class Reserva {
    private int id;
    private String cliente;
    private String libro;
    private Date fechaReserva;
    private String estado;

    // Constructors, getters, and setters

    public Reserva(int id, String cliente, String libro, Date fechaReserva, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.libro = libro;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
    }

    // Getters and Setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Optional: Override toString() for debugging purposes
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", libro='" + libro + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", estado='" + estado + '\'' +
                '}';
    }
}
