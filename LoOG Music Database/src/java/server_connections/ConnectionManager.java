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

    public static Connection getConnection() {
        return getConnection(Credentials.getUsername(), Credentials.
                getPassword());
    }

    public static Connection getConnection(String username, String password) {
        Connection connection = null;
        try {
            String drivers = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://dethorpe.me";
            System.setProperty(drivers, "");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return connection;
    }
}
