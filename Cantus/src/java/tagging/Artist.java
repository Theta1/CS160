package tagging;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A tag that can store the first name and last name of a song's artist.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class Artist extends SongTag implements Comparable<Artist> {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Artist.class.getName());

    static Artist createArtist(String name) throws SQLException {
        String nameForSQL = "'" + name + "'";
        HashMap<String, String> properties = new HashMap<>(1);
        properties.put("Name", nameForSQL);
        Artist temp = new Artist();
        int rowCount = temp.addAsRow(properties);
        Artist newArtist = new Artist(rowCount);
        return newArtist;
    }

    private final int id;

    /**
     * Creates a temporary instance that allows overridden methods to be used.
     */
    private Artist() {
        id = 0;
    }

    /**
     *
     * @param id row id in table
     */
    public Artist(int id) {
        this.id = id;
    }

    /**
     *
     * @return the full name of the artist
     */
    public String getFullName() {
        try {
            ResultSet results = getProperty("Name");
            results.next();
            return results.getString(1);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getTagType() {
        return "Artist";
    }

    @Override
    public String getTagText() {
        return getFullName();
    }

    @Override
    public String getTableName() {
        return "artists";
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public int compareTo(Artist t) {
        return getFullName().compareToIgnoreCase(t.getFullName());
    }

    @Override
    protected String getIDColumnName() {
        return "aKey";
    }

}
