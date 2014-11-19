package login_handling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Associates a user to a name and a password.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class User {

    private static final Logger LOG = Logger.getLogger(User.class.getName());

    /**
     * Registers a new user into the system.
     *
     * @param username the user's name
     * @param password the user's password
     * @throws SQLException
     */
    static User createUser(String username, String password) throws
            SQLException {
        setSQLUpdate(username, password);
        int newID = getUserID(username);
        User newUser = new User(newID);
        return newUser;
    }

    /**
     * Gets an ID number from a certain username.
     *
     * @param username the username to search
     * @return the next ID to use for a new user
     * @throws SQLException
     */
    private static int getUserID(String username) throws SQLException {
        String query = "SELECT `user_id` FROM `users` WHERE `username` = '";
        query += username;
        query += "'";
        Statement st = server_connections.ConnectionManager.
                getConnection().prepareStatement(query);
        ResultSet results = st.executeQuery(query);
        int newID = results.getInt(1);
        return newID;
    }

    /**
     * Adds a row via an SQL update.
     *
     * @param username the user's name
     * @param password the user's password
     * @return a row count
     * @throws SQLException
     */
    private static int setSQLUpdate(String username, String password) throws
            SQLException {
        String update = "INSERT INTO `users` (`username`, "
                + "`password`) VALUES (`";
        update += username;
        update += "`, `";
        update += password;
        update += "`)";
        Statement st = server_connections.ConnectionManager.
                getConnection().prepareStatement(update);
        int rowCount = st.executeUpdate(update);
        return rowCount;
    }

    private final int id;

    /**
     * Creates a User Java object from an existing user, using the ID value.
     *
     * @param id the ID of the user in the SQL database
     */
    User(int id) {
        this.id = id;
    }

    /**
     * Returns results from an SQL query.
     *
     * @param value the value to get from the row
     * @return results from the query
     * @throws SQLException
     */
    private ResultSet getSQLQuery(String value) throws
            SQLException {
        String query = "SELECT `";
        query += value;
        query += "` FROM `users` WHERE `user_id` = ";
        query += Integer.toString(id);
        query += "";
        PreparedStatement st = server_connections.ConnectionManager.
                getConnection().prepareStatement(query);
        ResultSet results = st.executeQuery(query);
        return results;
    }

    /**
     *
     * @return this user's name
     */
    String getUsername() throws SQLException {
        ResultSet results = getSQLQuery("username");
        String username = results.getString(1);
        return username;
    }

    /**
     *
     * @return this user's password
     * @throws SQLException
     */
    private String getPassword()
            throws SQLException {
        ResultSet results = getSQLQuery("password");
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
    int comparePassword(String enteredPassword)
            throws SQLException {
        return getPassword().compareTo(enteredPassword);
    }

}
