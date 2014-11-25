package library_handling;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import login_handling.User;
import server_connections.SQLStatements;

/**
 * Contains individual, personal MusicLibraries.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class MusicLibraryDatabase {

    private Map<User, MusicLibrary> libraries;

    public MusicLibraryDatabase() {
        libraries = new HashMap<>();
    }

    /**
     * Gives access to the library of the specified user.
     *
     * @param user the user whose library will be returned
     * @return the music library of this user
     */
    public MusicLibrary getMusicLibrary(User user) {
        //Create a library if user is new.
        if (!libraries.containsKey(user)) {
            libraries.put(user, MusicLibrary.createLibrary());
        }
        return libraries.get(user);
    }
    private static final Logger LOG = Logger.getLogger(MusicLibraryDatabase.class.getName());

    private static ResultSet getSQLQuery(String value, String keyType,
            String key) throws SQLException {
        String table = "libraries";
        ResultSet results = SQLStatements.getSQLQuery(value, table, keyType,
                key);
        return results;
    }
}
