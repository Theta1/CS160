package login_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_connections.SQLStatements;

/**
 *
 * A collection of users songs
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class LibraryDatabase {

    private static final Logger LOG = Logger.getLogger(UserDatabase.class.
            getName());

    public LibraryDatabase() {
    }

    /** Use for referance from userDB
     * Not needed to "add user" but needed to "add tags"
     * Adds a new user.
     *
     * @param username the user's name
     * @param password the user's password
     * @return false if the user already exists
     
    public boolean signUp(String username, String password) {
        try {
            if (getUser(username) == null) {
                return (User.createUser(username, password) != null);
            } else {
                return false;
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
}
