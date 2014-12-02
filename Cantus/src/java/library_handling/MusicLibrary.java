package library_handling;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Contains songs owned by a specific user.
 *
 * TODO Take POST data from ADDASONG.HTML Searches the DB for song (if not
 * empty) associated with song's table and returns the ID of row if nothing is
 * found inserts song as new row and stores ID
 *
 * Searches the DB for each field (if not empty) associated with field's table
 * and returns the ID of row if nothing is found inserts field as new row and
 * stores ID
 *
 * If SONG or a FIELD didn't exhist then store song ID and field ID in
 * song_has_field table
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class MusicLibrary {

    private static final Logger LOG = Logger.getLogger(MusicLibrary.class.getName());

    static MusicLibrary createLibrary() {
        return new MusicLibrary(0);
    }

    private final Set<Song> songs = new HashSet<>(0);
    private final int id;

    MusicLibrary(int id) {
        this.id = id;
    }

    /**
     *
     * @return songs in this library
     */
    public Set<Song> getSongs() {
        Set<Song> songs = new HashSet<>();
        return Collections.unmodifiableSet(songs);
    }

}
