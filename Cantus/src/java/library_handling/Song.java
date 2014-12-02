package library_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_connections.SQLStatements;
import tagging.ISongTag;

/**
 * A song contains its title and any number of tags that describe the song.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class Song implements Comparable<Song> {

    private static final Logger LOG = Logger.getLogger(Song.class.getName());

    private final static String tableName = "tracks";

    /**
     * Returns results from an SQL query.
     *
     * @param value the value to get from the row
     * @param keyType the row to look for the key
     * @param key the key to search from keyType's column
     * @return results from the query
     * @throws SQLException
     */
    private static ResultSet getSQLQuery(String value, String keyType,
            String key) throws SQLException {
        ResultSet results = SQLStatements.getSQLQuery(value, tableName, keyType,
                key);
        return results;
    }
    private final int id;

    /**
     *
     * @param id the id of the song in the data table
     */
    Song(int id) {
        this.id = id;
    }

    /**
     *
     * @param title the title of the song
     * @return a new song in the database
     * @throws java.sql.SQLException
     */
    public Song createSong(String title) throws SQLException {
        String keys = "`Title`";
        String values = "'";
        values += title;
        values += "'";
        int rowCount = SQLStatements.setSQLUpdate(tableName, keys, values);
        Song newSong = new Song(rowCount);
        return newSong;
    }

    /**
     *
     * @return the title of this song
     */
    public String getTitle() {
        try {
            String value = "Title";
            String keyType = "TrackID";
            String key = Integer.toString(id);
            ResultSet results = getSQLQuery(value, keyType, key);
            results.next();
            String username = results.getString(1);
            return username;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public int compareTo(Song o) {
        return getTitle().compareToIgnoreCase(o.getTitle());
    }
}
