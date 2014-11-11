package server_connections;

import java.sql.Connection;
import java.sql.Driver;
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
            Driver myDriver = new com.mysql.jdbc.Driver();
            String url = "jdbc:mysql://localhost:8084/";
            String username = Credentials.getUsername();
            String password = Credentials.getPassword();
            DriverManager.registerDriver(myDriver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
