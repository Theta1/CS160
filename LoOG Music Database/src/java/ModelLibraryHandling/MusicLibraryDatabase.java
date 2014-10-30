package ModelLibraryHandling;

import ModelLoginHandling.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 */
public class MusicLibraryDatabase {

    private Map<User, MusicLibrary> libraries;

    public MusicLibraryDatabase() {
        libraries = new HashMap<>();
    }

    public MusicLibrary getMusicLibrary(User user) {
        //Create a library if user is new.
        if (!libraries.containsKey(user)) {
            libraries.put(user, new MusicLibrary());
        }
        return libraries.get(user);
    }
}
