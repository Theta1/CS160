package ModelLibraryHandling;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 */
public class MusicLibrary {

    private Set<Song> songs;

    MusicLibrary() {
        songs = new HashSet<Song>();
    }

    public Set<Song> getSongs() {
        return songs;
    }
}
