package tagging;

import java.io.Serializable;

/**
 * Tags have a name, denoting its type, and text, describing its content/
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public interface ISongTag extends Serializable {

    /**
     *
     * @return the name of the tag, denoting its type
     */
    public String getTagType();

    /**
     *
     * @return the content of this tag, as a string
     */
    public String getTagText();
}
