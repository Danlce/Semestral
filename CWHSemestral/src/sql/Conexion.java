package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 

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
                clientes.add(nombre + "   " + telefono + "   " + direccion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}

