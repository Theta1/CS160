package library_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_connections.DatabaseItemWrapper;
import tagging.SongGroup;

/**
 * A song contains its title and any number of tags that describe the song.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class Song extends DatabaseItemWrapper implements Comparable<Song> {

    private static final Logger LOG = Logger.getLogger(Song.class.getName());
    private static final String tableName = "tracks";
    private static final String idColumnName = "TrackID";
    private static final String titleColumnName = "Title";

    /**
     *
     * @param title the title of the song
     * @return a new song in the database
     * @throws java.sql.SQLException
     */
    static Song createSong(String title) throws SQLException {
        String titleForSQL = "'" + title + "'";
        HashMap<String, String> properties = new HashMap<>(1);
        properties.put(titleColumnName, titleForSQL);
        Song temp = new Song();
        int rowCount = temp.addAsRow(properties);
        Song newSong = new Song(rowCount);
        return newSong;
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
     * Creates a temporary instance that allows overridden methods to be used.
     */
    private Song() {
        id = 0;
    }

    /**
     *
     * @return the title of this song
     */
    public String getTitle() {
        try {
            ResultSet results = getProperty(titleColumnName);
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

    /**
     *
     * @return the group of this song
     */
    public SongGroup getGroup() {
        return SongGroup.getGroupOfSong(id);
    }

    @Override
    protected int getID() {
        return id;
    }

    @Override
    protected String getTableName() {
        return tableName;
    }

    @Override
    protected String getIDColumnName() {
        return idColumnName;
    }
}
