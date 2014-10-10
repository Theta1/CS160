package LoginHandling;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 */
public class UserDatabase {
    
    private Set<User> users;
    
    private User getUser(String username) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User nextUser = it.next();
            if (username.equals(nextUser.getUsername())) {
                return nextUser;
            }
        }
        return null;
    }
    
    public boolean signUp(User signup) {
        boolean usernameAvailable = (getUser(signup.getUsername()) == null);
        if (usernameAvailable) {
            users.add(signup);
        }
        return usernameAvailable;
    }
    
    public boolean authenticateLogin(User login) {
        boolean ret = users.contains(login);
        return ret;
    }
}
