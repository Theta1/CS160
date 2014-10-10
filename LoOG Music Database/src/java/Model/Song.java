package Model;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 */
public class Song {

    private String title;
    private Set<Author> authors;

    public Song(String title, Set<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
