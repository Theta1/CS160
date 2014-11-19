package login_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * A collection of users.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class UserDatabase {

    private static final Logger LOG = Logger.getLogger(UserDatabase.class.
            getName());

    public UserDatabase() {
    }

    /**
     * Adds a new user.
     *
     * @param username the user's name
     * @param password the user's password
     * @return false if the user already exists
     * @throws SQLException
     */
    public boolean signUp(String username, String password) throws
            SQLException {
        return (User.createUser(username, password) != null);
    }

    /**
     * Returns a User object after verifying that the entered username-password
     * combination is correct.
     *
     * @param username the entered username
     * @param password the entered password
     * @return the User object whose username and password match, if it exists,
     * throws IllegalArgumentException otherwise
     * @throws SQLException
     * @throws IllegalArgumentException
     */
    public User logIn(String username, String password) throws SQLException {
        User user = getUser(username);
        if ((user != null) && (user.comparePassword(password) == 0)) {
            return user;
        }
        throw new IllegalArgumentException("Incorrect username or password.");
    }

    /**
     * Returns a User object from the requested username
     *
     * @param username the username for which to search
     * @return null if no user is found
     */
    private User getUser(String username) throws SQLException {
        Statement statement = server_connections.ConnectionManager.
                getConnection().createStatement();
        String query = "SELECT `user_id` FROM `users` WHERE `username` = '";
        query += username;
        query += "'";
        ResultSet results = statement.executeQuery(query);
        int nextInt = results.getInt(1);
        User ret = new User(nextInt);
        return ret;
    }
}
