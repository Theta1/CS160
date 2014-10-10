package Model;

import java.util.Collection;
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

    Collection<Song> getSongs() {
        return songs;
    }
}
