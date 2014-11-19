package server_connections;

import java.util.logging.Logger;

/**
 * Stores the username and password for the SQL server.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class Credentials {

    private static final Logger LOG = Logger.getLogger(Credentials.class.getName());

    /**
     * Change to actual username before building!
     *
     * @return our SQL username
     */
    static String getUsername() {
        return "root";
    }

    /**
     * Change to actual password before building!
     *
     * @return our SQL password
     */
    static String getPassword() {
        return "workhard";
    }

    private Credentials() {
    }
}
