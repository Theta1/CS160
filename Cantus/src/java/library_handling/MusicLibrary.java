package library_handling;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains songs owned by a specific user.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class MusicLibrary {

    private final Set<Song> songs = new HashSet<>(0);
    private final int id;

    MusicLibrary(int id) {
        this.id = id;
    }

    static MusicLibrary createLibrary() {
        return new MusicLibrary(0);
    }

    /**
     *
     * @return songs in this library
     */
    public Set<Song> getSongs() {
        return Collections.unmodifiableSet(songs);
    }
}
