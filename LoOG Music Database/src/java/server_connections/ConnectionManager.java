package server_connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages the connection to the SQL server.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class ConnectionManager {

    private static Connection connection;

    static {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.err.println(ex);
            }
            String url = "jdbc:mysql://localhost:8084/";
            String username = Credentials.getUsername();
            String password = Credentials.getPassword();
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     *
     * @return a connection to the SQL Cantus database.
     */
    public static Connection getConnection() {
        return connection;
    }
}
