package tagging;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_connections.SQLStatements;

/**
 * A group is a collection of artists who make the same songs.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class SongGroup extends SongTag {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(SongGroup.class
            .getName());

    /**
     * Creates a new song group into the database.
     *
     * @param name the name of the group or band
     * @return a wrapper for the new group
     */
    public static SongGroup createGroup(String name) {
        try {
            HashMap<String, String> properties = new HashMap<>(1);
            String nameForSQL = "'" + name + "'";
            properties.put("Name", nameForSQL);
            SongGroup temp = new SongGroup();
            return new SongGroup(temp.addAsRow(properties));
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param songID the ID of the song for which to look
     * @return the group of the specified song
     */
    public static SongGroup getGroupOfSong(int songID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private final int id;

    /**
     * Creates a temporary instance that allows overridden methods to be used.
     */
    private SongGroup() {
        id = 0;
    }

    /**
     *
     * @param id the row ID of this group in the table
     */
    public SongGroup(int id) {
        this.id = id;
    }

    @Override
    public String getTagType() {
        return "Group";
    }

    @Override
    public String getTagText() {
        return getName();
    }

    @Override
    public String getTableName() {
        return "groups";
    }

    @Override
    public int getID() {
        return id;
    }

    /**
     *
     * @return name of this group or band
     */
    public String getName() {
        try {
            ResultSet results = getProperty("Name");
            results.next();
            return results.getString(1);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return "";
        }
    }

    /**
     * Adds an artist to this group.
     *
     * @param a the artist to add
     * @return true if added successfully
     */
    public boolean addArtist(Artist a) {
        try {
            HashMap<String, String> artistContainer = new HashMap<>(2);
            artistContainer.put("artistKey", Integer.toString(a.getID()));
            artistContainer.put("groupsKey", Integer.toString(getID()));
            SQLStatements.insert("artists_has_groups", artistContainer);
            return true;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Removes an artist from this group.
     *
     * @param a the artist to remove
     * @return the removed artist
     */
    public Artist removeArtist(Artist a) {
        throw new UnsupportedOperationException();
    }

    /**
     * Searches the database for each artist in group. Creates an unmodifiable
     * TreeSet of the artist
     *
     * @return a set of all artists in this group
     */
    public SortedSet<Artist> getArtists() {
        try {
            TreeSet<Artist> t = new TreeSet<>();
            ResultSet results = SQLStatements.selectWhere("artistKey",
                    "artist_has_group", "groupsKey", Integer.toString(id));
            while (results.next()) {
                int ids = results.getInt(1);
                t.add(new Artist(ids));
            }
            SortedSet<Artist> u = Collections.unmodifiableSortedSet(t);
            return u;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    protected String getIDColumnName() {
        return "groups";
    }

}
