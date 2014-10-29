package LoginHandling;

import java.util.HashMap;
import java.util.Map;

/**
 * A collection of users.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 */
public class UserDatabase {

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
     */
    public boolean signUp(String username, String password) {
        boolean usernameAvailable = !users.containsKey(username);
        if (usernameAvailable) {
            users.put(username, new User(username, password));
        }
        return usernameAvailable;
    }

    /**
     * Verifies that the entered username-password combination is correct.
     *
     * @param username the entered username
     * @param password the entered password
     * @return true if the entered information in correct
     */
    public boolean authenticateLogin(String username, String password) {
        User user = users.get(username);
        if (user == null) {
            return false;
        }
        return (user.comparePassword(password) == 0);
    }
}
