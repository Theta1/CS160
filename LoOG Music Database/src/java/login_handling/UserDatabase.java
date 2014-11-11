package login_handling;

import java.lang.IllegalArgumentException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A collection of users.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class UserDatabase implements Serializable {

    private Map<String, User> users;

    public UserDatabase() {
        users = new HashMap<>();
    }

    /**
     * Adds a new user.
     *
     * @param username the user's name
     * @param password the user's password
     * @return false if the user already exists
     * @throws SQLException
     */
    public boolean signUp(String username, String password) throws SQLException {
        boolean usernameAvailable = !users.containsKey(username);
        if (usernameAvailable) {
            users.put(username, User.createUser(username, password));
        }
        return usernameAvailable;
    }

    /**
     * Returns a User object after verifying that the entered username-password
     * combination is correct.
     *
     * @param username the entered username
     * @param password the entered password
     * @return the User object whose username and password match, if it exists,
     * null otherwise
     * @throws SQLException
     */
    public User logIn(String username, String password) throws SQLException {
        User user = users.get(username);
        if ((user != null) && (user.comparePassword(password) == 0)) {
            return user;
        }
        throw new IllegalArgumentException("Incorrect username of password.");
    }
}
