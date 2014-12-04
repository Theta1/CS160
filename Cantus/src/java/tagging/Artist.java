package tagging;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    private final int id;

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
