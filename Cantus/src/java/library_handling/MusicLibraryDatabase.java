package library_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import login_handling.User;
import server_connections.SQLStatements;
import tagging.Artist;
import tagging.SongGroup;

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
     * @return an unmodifiable List
     */
    public static List<Song> getAllSongs() {
        ArrayList<Song> initialSet = new ArrayList<>(0);
        try {
            ResultSet results = SQLStatements.select("TrackID", "tracks");
            while (results.next()) {
                initialSet.add(new Song(results.getInt(1)));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return Collections.unmodifiableList(initialSet);
    }

    /**
     * Returns an unmodifiable collection of every song group in the database.
     *
     * @return an unmodifiable List
     */
    public static List<SongGroup> getAllGroups() {
        ArrayList<SongGroup> initialSet = new ArrayList<>(0);
        try {
            ResultSet results = SQLStatements.select("gKey", "groups");
            while (results.next()) {
                initialSet.add(new SongGroup(results.getInt(1)));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return Collections.unmodifiableList(initialSet);
    }

    /**
     * Returns an unmodifiable collection of every artist in the database.
     *
     * @return an unmodifiable List
     */
    public static List<Artist> getAllArtists() {
        ArrayList<Artist> initialSet = new ArrayList<>(0);
        try {
            ResultSet results = SQLStatements.select("aKey", "artists");
            while (results.next()) {
                initialSet.add(new Artist(results.getInt(1)));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return Collections.unmodifiableList(initialSet);
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

    /**
     * Removes the specified song from the database.
     *
     * @param s the song to remove
     * @return true if successful
     */
    public static boolean removeSong(Song s) {
        try {
            SQLStatements.delete(s.getTableName(), s.getIDColumnName(),
                    Integer.toString(s.getID()));
            return true;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Creates a new group entry for this database.
     *
     * @param name the name of the group or band
     * @return a wrapper of the group, if successful
     */
    public static SongGroup addGroup(String name) {
        return SongGroup.createGroup(name);
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
