package library_handling;

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

    private Set<Song> songs;

    MusicLibrary() {
        songs = new HashSet<>();
    }

    /**
     *
     * @return songs in this library
     */
    public Set<Song> getSongs() {
        return songs;
    }
}
