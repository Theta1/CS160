package library_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
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

    private static final Logger LOG = Logger.getLogger(
            MusicLibraryDatabase.class.getName());

    private static ResultSet getSQLQuery(String value, String keyType,
            String key) throws SQLException {
        String table = "libraries";
        ResultSet results = SQLStatements.getSQLQueryWhere(value, table, keyType,
                key);
        return results;
    }

    public MusicLibraryDatabase() {

    }

    /**
     * Gives access to the library of the specified user.
     *
     * @param user the user whose library will be returned
     * @return the music library of this user
     */
    public MusicLibrary getMusicLibrary(User user) {
        //Create a library if user is new.
        throw new UnsupportedOperationException();
    }

    public SortedSet<Song> getSongs() {
        TreeSet<Song> initialList = new TreeSet<>();
        try {
            String value = "TrackID";
            String table = "tracks";
            ResultSet results = SQLStatements.getSQLQuery(value, table);
            while (results.next()) {
                int nextID = results.getInt(1);
                Song nextSong = new Song(nextID);
                initialList.add(nextSong);
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        SortedSet<Song> returnList = Collections.unmodifiableSortedSet(
                initialList);
        return returnList;
    }
}
