package tagging;

import server_connections.DatabaseItemWrapper;

/**
 * A convenience class for implementations of ISongType.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public abstract class SongTag extends DatabaseItemWrapper implements ISongTag {

    private static final long serialVersionUID = 1L;
}
