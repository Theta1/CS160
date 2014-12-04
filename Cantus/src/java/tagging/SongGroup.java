package tagging;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
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
public class SongGroup implements ISongTag {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(SongGroup.class.getName());

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
     *
     * @param id the row ID of this group in the table
     */
    SongGroup(int id) {
        this.id = id;
    }

    @Override
    public String getTagType() {
        return "Group";
    }

    @Override
    public String getTagText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * Searches the database for each artist in group. Creates an unmodifiable
     * TreeSet of the artist
     *
     * @return a set of all artists in this group
     */
    public SortedSet<Artist> getArtists() {
        try {
            TreeSet<Artist> t = new TreeSet<>();
            ResultSet results = SQLStatements.selectWhere("artistKey", "artist_has_group", "groupsKey", Integer.toString(id));
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

}
