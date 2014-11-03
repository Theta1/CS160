package library_handling;

import tagging.ISongTag;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A song contains its title and any number of tags that describe the song.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class Song {

    private String title;
    private Map<String, Set<ISongTag>> tags;

    /**
     *
     * @param title the title of the song
     */
    public Song(String title) {
        this(title, new HashMap<String, Set<ISongTag>>());
    }

    /**
     *
     * @param title the title of the song
     * @param tags a set containing tags for the song
     */
    public Song(String title, Map<String, Set<ISongTag>> tags) {
        this.title = title;
        this.tags = tags;
    }

    /**
     *
     * @return the title of this song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a set of all tags of the specified type.
     *
     * @param tagType the name of the type of the tags to return
     * @return a set of all tags of the specified type
     */
    public Set<ISongTag> getSongTagsOfType(String tagType) {
        //Add tag type if it does not exist.
        if (!tags.containsKey(tagType)) {
            tags.put(tagType, new HashSet<ISongTag>());
        }
        return tags.get(tagType);
    }
}
