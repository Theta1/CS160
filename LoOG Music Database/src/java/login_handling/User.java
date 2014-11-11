package login_handling;

import java.io.Serializable;

/**
 * Associates a user to a name and a password.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class User implements Serializable {

    private String username;
    private String password;

    /**
     *
     * @param username the user's name
     * @param password the user's password
     */
    User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    /**
     *
     * @return this user's name
     */
    String getUsername() {
        return username;
    }

    /**
     * Sets this user's name.
     *
     * @param newUsername new value for username
     */
    private void setUsername(String newUsername) {
        username = newUsername;
    }

    /**
     *
     * @return this user's password
     */
    private String getPassword() {
        return password;
    }

    /**
     * Sets this user's password.
     *
     * @param newPassword new value for password
     */
    private void setPassword(String newPassword) {
        password = newPassword;
    }

    /**
     * Compares a user-entered password to the real password.
     *
     * @param enteredPassword the password entered by the user
     * @return 0 if the passwords match
     */
    int comparePassword(String enteredPassword) {
        return getPassword().compareTo(enteredPassword);
    }
}
