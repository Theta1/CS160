package library_handling;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_connections.SQLStatements;

/**
 * Contains songs owned by a specific user.
 *
 * TODO Take POST data from ADDASONG.HTML Searches the DB for song (if not
 * empty) associated with song's table and returns the ID of row if nothing is
 * found inserts song as new row and stores ID
 *
 * Searches the DB for each field (if not empty) associated with field's table
 * and returns the ID of row if nothing is found inserts field as new row and
 * stores ID
 *
 * If SONG or a FIELD didn't exhist then store song ID and field ID in
 * song_has_field table
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class MusicLibrary {
    static MusicLibrary createLibrary() {
        return new MusicLibrary();
    }
    public MusicLibrary(){
    }
    
    /**
    * Queries the Database for tag list based on keyType and key.
    * @param keyType is a string containing the table to search in.
    * @param key is the item name to search for. Can be an empty string to return all items.
    * @return is the result of type ResultSet
    */
    public ResultSet getTable(String keyType, String key ) throws SQLException {
        ResultSet trackList;
        if(key.length()!=0)
            trackList = SQLStatements.getSQLQuery("*", "tracks", "keyType", "key");
        else
            trackList = SQLStatements.getSQLQuery("*", "tracks", "keyType", "");
        return trackList;
    }
    //public void store
}
