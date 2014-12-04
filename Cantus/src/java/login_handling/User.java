package login_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;
import server_connections.DatabaseItemWrapper;

/**
 * Associates a user to a name and a password.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class User extends DatabaseItemWrapper {

    private static final Logger LOG = Logger.getLogger(User.class.getName());
    private static final String tableName = "users";
    private static final String idColumnName = "user_id";
    private static final String nameColumnName = "username";
    private static final String passwordColumnName = "password";

    /**
     * Registers a new user into the system.
     *
     * @param username the user's name
     * @param password the user's password
     * @throws SQLException
     */
    static User createUser(String username, String password) throws SQLException {
        HashMap<String, String> properties = new HashMap<>(2);
        String apostrophe = "'";
        String usernameForSQL = apostrophe + username + apostrophe;
        String passwordForSQL = apostrophe + password + apostrophe;
        properties.put(nameColumnName, usernameForSQL);
        properties.put(passwordColumnName, passwordForSQL);
        User temp = new User();
        int newID = temp.addAsRow(properties);
        User newUser = new User(newID);
        return newUser;
    }

    private final int id;

    /**
     * Creates a temporary instance that allows overridden methods to be used.
     */
    private User() {
        id = 0;
    }

    /**
     * Creates a User Java object from an existing user, using the ID value.
     *
     * @param id the ID of the user in the SQL database
     */
    User(int id) {
        this.id = id;
    }

    /**
     *
     * @return this user's name
     */
    String getUsername() throws SQLException {
        ResultSet results = getProperty(nameColumnName);
        results.next();
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
        ResultSet results = getProperty(passwordColumnName);
        results.next();
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

    @Override
    protected int getID() {
        return id;
    }

    @Override
    protected String getTableName() {
        return tableName;
    }

    @Override
    protected String getIDColumnName() {
        return idColumnName;
    }

}
