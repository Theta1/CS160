package tagging;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Logger;

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
     *
     * @return a set of all artists in this group
     */
    public TreeSet<Artist> getArtists() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param songID the ID of the song for which to look
     * @return the group of the specified song
     */
    public static SongGroup getGroupOfSong(int songID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
