package login_handling;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Associates a user to a name and a password.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class User implements Serializable {

    private int id;

    /**
     * Creates a User Java object from an existing user, using the ID value.
     *
     * @param id the ID of the user in the SQL database
     */
    User(int id) {
        this.id = id;
    }

    /**
     * Registers a new user into the system.
     *
     * @param username the user's name
     * @param password the user's password
     * @throws SQLException
     */
    static User createUser(String username, String password) throws
            SQLException {
        int newID = getNextUserID();
        setSQLUpdate(newID, username, password);
        User newUser = new User(newID);
        return newUser;
    }

    /**
     *
     * @return the next ID to use for a new user
     * @throws SQLException
     */
    private static int getNextUserID() throws SQLException {
        Statement statement = server_connections.ConnectionManager.
                getConnection().createStatement();
        ResultSet results = statement.executeQuery(
                "SELECT MAX('user_id') FROM 'users'");
        int newID = results.getInt(1) + 1;
        return newID;
    }

    /**
     * Returns results from an SQL query.
     *
     * @param value the value to get from the row
     * @return results from the query
     * @throws SQLException
     */
    private ResultSet getSQLQuery(String value) throws SQLException {
        Statement statement = server_connections.ConnectionManager.
                getConnection().createStatement();
        String query = "SELECT ";
        query += value;
        query += " FROM `users` WHERE `user_id` = ";
        query += Integer.toString(id);
        ResultSet results = statement.executeQuery(query);
        return results;
    }

    /**
     * Adds a row via an SQL update.
     *
     * @param id a unique ID number to be used as a key
     * @param username the user's name
     * @param password the user's password
     * @return a row count
     * @throws SQLException
     */
    private static int setSQLUpdate(int id, String username, String password)
            throws SQLException {
        Statement statement = server_connections.ConnectionManager.
                getConnection().createStatement();
        String update = "INSERT INTO `cantus`.`users` (`user_id`, `username`, "
                + "`password`) VALUES (";
        update += Integer.toString(id);
        update += ", '";
        update += username;
        update += "', '";
        update += password;
        update += "')";
        int rowCount = statement.executeUpdate(update);
        return rowCount;
    }

    /**
     *
     * @return this user's name
     */
    String getUsername() throws SQLException {
        ResultSet results = getSQLQuery("'username'");
        String username = results.getString(1);
        return username;
    }

    /**
     *
     * @return this user's password
     * @throws SQLException
     */
    private String getPassword() throws SQLException {
        ResultSet results = getSQLQuery("'password'");
        String password = results.getString(1);
        return password;
    }

    /**
     * Compares a user-entered password to the real password.
     *
     * @param enteredPassword the password entered by the user
     * @return 0 if the passwords match
     * @throws SQLException
     */
    int comparePassword(String enteredPassword) throws SQLException {
        return getPassword().compareTo(enteredPassword);
    }
}
