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
        connection = null;
    }

    private static void initializeConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String username = Credentials.getUsername();
        String password = Credentials.getPassword();
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(url, username, password);
    }

    /**
     *
     * @return a connection to the SQL Cantus database.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            initializeConnection();
        }
        return connection;
    }
}
