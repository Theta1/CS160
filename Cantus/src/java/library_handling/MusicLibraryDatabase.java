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

    /**
     * Returns an unmodifiable collection of every song in the database.
     *
     * @return an unmodifiable SortedSet
     */
    public static SortedSet<Song> getAllSongs() {
        TreeSet<Song> initialSet = new TreeSet<>();
        try {
            ResultSet results = SQLStatements.select("TrackID", "tracks");
            while (results.next()) {
                initialSet.add(new Song(results.getInt(1)));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return Collections.unmodifiableSortedSet(initialSet);
    }

    /**
     * Creates a new song entry for this database.
     *
     * @param title title of the song
     * @param genre genre of the song
     * @return true if the addition succeeded
     */
    public static Song addSong(String title, String genre) {
        Song addedSong = addSong(title);
        if (addedSong != null) {
            addedSong.setGenre(genre);
        }
        return addedSong;
    }

    /**
     * Creates a new song entry for this database.
     *
     * @param title title of the song
     * @return true if the addition succeeded
     */
    public static Song addSong(String title) {
        try {
            return Song.createSong(title);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
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
}
