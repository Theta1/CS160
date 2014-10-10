package Model;

import LoginHandling.User;
import LoginHandling.UserDatabase;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 */
public class MusicLibraryDatabase {

    private Map<String, MusicLibrary> libraries;
    private UserDatabase userDatabase;

    public MusicLibraryDatabase() {
        libraries = new HashMap<String, MusicLibrary>();
        userDatabase = new UserDatabase();
    }

    public boolean signUp(User signup) {
        boolean signedUp = userDatabase.signUp(signup);
        if (signedUp) {
            MusicLibrary newLibrary = new MusicLibrary();
            libraries.put(signup.getUsername(), newLibrary);
        }
        return signedUp;
    }

    public MusicLibrary logIn(User login) {
        if (userDatabase.authenticateLogin(login)) {
            MusicLibrary library = libraries.get(login.getUsername());
            return library;
        }
        return null;
    }
}
