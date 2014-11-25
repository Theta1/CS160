package server_connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Manages SQL statements.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public class SQLStatements {

    private static final Logger LOG = Logger.getLogger(SQLStatements.class
            .getName());

    /**
     * Returns results from an SQL query.
     *
     * @param value the value to get from the row
     * @param table the table to use for the query
     * @param keyType the row to look for the key
     * @param key the key to search from keyType's column
     * @return results from the query
     * @throws SQLException
     */
    public static ResultSet getSQLQuery(String value, String table,
            String keyType, String key) throws SQLException {
        String query = "SELECT `";
        query += value;
        query += "` FROM `";
        query = table;
        query += "` WHERE `";
        query += keyType;
        query += "` = ";
        query += key;
        Statement st = server_connections.ConnectionManager.
                getConnection().createStatement();
        ResultSet results = st.executeQuery(query);
        return results;
    }

    private SQLStatements() {
    }
}
