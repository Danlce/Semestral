package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class Conexion {
		  // Database connection details
	    private static final String URL = "jdbc:mysql://byawxi2qvrw1ycvt1exn-mysql.services.clever-cloud.com:3306/byawxi2qvrw1ycvt1exn";
	    private static final String USER = "um8pasj1fea2jdw4";
	    private static final String PASSWORD = "BhXZGxKZBVZvPRx5s6p9";

	    public static void main(String[] args) {
	        Connection connection = null;

	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish the connection
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);

	            if (connection != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }

	        } catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Connection failed! Check output console");
	            e.printStackTrace();
	        } finally {
	            // Close the connection
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}