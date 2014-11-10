package login_handling;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
     */
    public boolean signUp(String username, String password) {
        boolean usernameAvailable = !users.containsKey(username);
        if (usernameAvailable) {
            users.put(username, new User(username, password));
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
     */
    public User logIn(String username, String password) {
        User user = users.get(username);
        if ((user != null) && (user.comparePassword(password) == 0)) {
            return user;
        }
        return null;
    }
}
