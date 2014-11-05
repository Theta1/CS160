package taggingTEMP;

/**
 * A convenience class for implementations of ISongType. Has a pre-built
 * constructor.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public abstract class SongTag implements ISongTag {

    private String tagText;

    public SongTag(String tagText) {
        this.tagText = tagText;
    }

    @Override
    public String getTagText() {
        return tagText;
    }
}
