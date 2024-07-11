package sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import logica.Libro;

public class Conexion {
    // Database connection details
    private static final String URL = "jdbc:mysql://byawxi2qvrw1ycvt1exn-mysql.services.clever-cloud.com:3306/byawxi2qvrw1ycvt1exn";
    private static final String USER = "um8pasj1fea2jdw4";
    private static final String PASSWORD = "BhXZGxKZBVZvPRx5s6p9";

    private Connection conectar() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertarCliente(String nombre, String telefono, String direccion) {
        String sql = "INSERT INTO clientes (nombre, telefono, direccion) VALUES (?, ?, ?)";

        try (Connection connection = conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, direccion);
            preparedStatement.executeUpdate();
            System.out.println("Cliente agregado exitosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerClientes() {
        List<String> clientes = new ArrayList<>();
        String sql = "SELECT nombre, telefono, direccion FROM clientes";

        try (Connection connection = conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String direccion = resultSet.getString("direccion");
                clientes.add(nombre + " " + telefono + " " + direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void borrarCliente(String nombre) {
        String sql = "DELETE FROM clientes WHERE nombre = ?";

        try (Connection connection = conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.executeUpdate();
            System.out.println("Cliente borrado exitosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void actualizarCliente(String nombreOriginal, String nuevoNombre, String nuevoTelefono, String nuevaDireccion) {
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, direccion = ? WHERE nombre = ?";

        try (Connection connection = conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setString(2, nuevoTelefono);
            preparedStatement.setString(3, nuevaDireccion);
            preparedStatement.setString(4, nombreOriginal);
            preparedStatement.executeUpdate();
            System.out.println("Cliente actualizado exitosamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertarLibro(String titulo, String autor, String anio, String genero, String idioma, String precio) {
        String sql = "INSERT INTO libros (titulo, autor, año, genero, idioma, precio, disponible) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setInt(3, Integer.parseInt(anio));
            preparedStatement.setString(4, genero);
            preparedStatement.setString(5, idioma);
            preparedStatement.setDouble(6, Double.parseDouble(precio));
            preparedStatement.setBoolean(7, true); // Disponibilidad por defecto a true

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> obtenerLibros() {
        List<String> libros = new ArrayList<>();
        String sql = "SELECT id, titulo, autor FROM libros";

        try (Connection connection = conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");

                libros.add(id + ": " + titulo + " - " + autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    } 
    public List<String> obtenerLibrosDisponibles() {
        List<String> libros = new ArrayList<>();
        String sql = "SELECT titulo FROM libros WHERE disponible = true";

        try (Connection connection = conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                libros.add(titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    
    public Libro obtenerLibroPorId(int id) {
        Libro libro = null;
        String sql = "SELECT * FROM libros WHERE id = ?";

        try (Connection connection = conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String genero = resultSet.getString("genero");
                int anio = resultSet.getInt("año"); // Cambio aquí
                String idioma = resultSet.getString("idioma");
                double precio = resultSet.getDouble("precio");
                boolean disponible = resultSet.getBoolean("disponible");

                libro = new Libro(id, titulo, autor, genero, anio, idioma, precio, disponible);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }
    public List<String> obtenerLibrosSinId() {
        List<String> libros = new ArrayList<>();
        String sql = "SELECT titulo, autor FROM libros";

        try (Connection connection = conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");

                libros.add(titulo + " - " + autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
    public void alquilarLibro(String nombreCliente, String tituloLibro, java.sql.Date fechaDevolucion) {
        // Obtener el ID del libro por título
        int libroId = obtenerIdLibroPorTitulo(tituloLibro);

        // Calcular fecha límite de devolución (7 días después de la fecha de devolución)
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaDevolucion);
        cal.add(Calendar.DAY_OF_MONTH, 7); // Sumar 7 días
        java.sql.Date fechaLimite = new java.sql.Date(cal.getTimeInMillis());

        // Insertar registro en la tabla de alquileres
        String sqlAlquiler = "INSERT INTO alquileres (id_libro, nombre_cliente, titulo_libro, fecha_alquiler, fecha_devolucion, fecha_limite_devolucion, importe_amonestacion) VALUES (?, ?, ?, CURDATE(), ?, ?, 0)";
        try (Connection connection = conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlAlquiler)) {
            preparedStatement.setInt(1, libroId);
            preparedStatement.setString(2, nombreCliente);
            preparedStatement.setString(3, tituloLibro);
            preparedStatement.setDate(4, fechaDevolucion);
            preparedStatement.setDate(5, fechaLimite);

            preparedStatement.executeUpdate();
            System.out.println("Libro alquilado correctamente por " + nombreCliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Actualizar disponibilidad del libro
        actualizarDisponibilidadLibro(libroId, false);
    }

        private int obtenerIdLibroPorTitulo(String tituloLibro) {
            int libroId = -1;
            String sql = "SELECT id FROM libros WHERE titulo = ?";

            try (Connection connection = conectar();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tituloLibro);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    libroId = resultSet.getInt("id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return libroId;
        }


    public void actualizarDisponibilidadLibro(int idLibro, boolean disponible) {
        String sql = "UPDATE libros SET disponible = ? WHERE id = ?";

        try (Connection connection = conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, disponible);
            preparedStatement.setInt(2, idLibro);

            preparedStatement.executeUpdate();
            System.out.println("Disponibilidad del libro actualizada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }

}
    public List<String> obtenerClientesConAlquileres() {
        List<String> clientes = new ArrayList<>();
        String sql = "SELECT c.nombre, a.titulo_libro, a.fecha_devolucion, a.importe_amonestacion " +
                     "FROM clientes c " +
                     "LEFT JOIN alquileres a ON c.nombre = a.nombre_cliente";

        try (Connection connection = conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("nombre");
                String tituloLibro = resultSet.getString("titulo_libro");
                Date fechaDevolucion = resultSet.getDate("fecha_devolucion");
                double amonestacion = resultSet.getDouble("importe_amonestacion");

                // Verificar si el título del libro es null
                if (tituloLibro != null) {
                    // Construir la cadena con la información del cliente y su alquiler
                    StringBuilder sb = new StringBuilder();
                    sb.append(nombreCliente);
                    sb.append(" - Alquiló: ");
                    sb.append(tituloLibro);
                    sb.append(", Fecha de devolución: ");
                    sb.append(fechaDevolucion);
                    sb.append(", Amonestación acumulada: ");
                    sb.append(amonestacion);

                    clientes.add(sb.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    public void borrarAlquiler(String nombreCliente, String tituloLibro) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Obtener el ID del libro por su título
            int libroId = obtenerIdLibroPorTitulo(tituloLibro);

            // Eliminar el registro de alquiler por nombre del cliente y título del libro
            String sql = "DELETE FROM alquileres WHERE nombre_cliente = ? AND titulo_libro = ?";

            connection = conectar();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreCliente);
            preparedStatement.setString(2, tituloLibro);

            preparedStatement.executeUpdate();
            System.out.println("Alquiler borrado correctamente para " + nombreCliente);

            // Actualizar la disponibilidad del libro a true
            actualizarDisponibilidadLibro(libroId, true);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    


}