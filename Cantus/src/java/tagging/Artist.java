package tagging;

import java.util.logging.Logger;

/**
 * A tag that can store the first name and last name of a song's artist.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class Artist implements ISongTag {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Artist.class.getName());

    private String firstName;
    private String lastName;
    private int id;

    /**
     *
     * @param firstName the forename of the artist
     * @param lastName the surname of the artist
     */
    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @return the forename of the artist
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return the surname of the artist
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return the full name of the artist
     */
    public String getFullName() {
        String fullName = getFirstName();
        fullName += " ";
        fullName += getLastName();
        return fullName;
    }

    @Override
    public String getTagType() {
        return "Artist";
    }

    @Override
    public String getTagText() {
        return getFullName();
    }

    @Override
    public String getTableName() {
        return "tags_artists";
    }

    @Override
    public int getID() {
        return id;
    }
}
