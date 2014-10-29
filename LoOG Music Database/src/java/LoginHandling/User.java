package LoginHandling;

/**
 * Associates a user to a name and a password.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 */
public class User {

    private String username;
    private String password;

    /**
     *
     * @param username the user's name
     * @param password the user's password
     */
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return this user's name
     */
    String getUsername() {
        return username;
    }

    /**
     * Compares a user-entered password to the real password.
     *
     * @param enteredPassword the password entered by the user
     * @return 0 if the passwords match
     */
    int comparePassword(String enteredPassword) {
        return password.compareTo(enteredPassword);
    }
}
