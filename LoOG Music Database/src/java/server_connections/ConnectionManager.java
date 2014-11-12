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
        initializeConnection();
    }

    private static void initializeConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:8084/";
            String username = Credentials.getUsername();
            String password = Credentials.getPassword();
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     *
     * @return a connection to the SQL Cantus database.
     */
    public static Connection getConnection() {
        if (connection == null) {
            initializeConnection();
        }
        return connection;
    }
}
