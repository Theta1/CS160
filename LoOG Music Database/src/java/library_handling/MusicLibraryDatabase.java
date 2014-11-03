package library_handling;

import login_handling.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains individual, personal MusicLibraries.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class MusicLibraryDatabase {

    private Map<User, MusicLibrary> libraries;

    public MusicLibraryDatabase() {
        libraries = new HashMap<>();
    }

    /**
     * Gives access to the library of the specified user.
     *
     * @param user the user whose library will be returned
     * @return the music library of this user
     */
    public MusicLibrary getMusicLibrary(User user) {
        //Create a library if user is new.
        if (!libraries.containsKey(user)) {
            libraries.put(user, new MusicLibrary());
        }
        return libraries.get(user);
    }
}
