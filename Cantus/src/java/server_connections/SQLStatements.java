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
     * @param keyType the row name to look for the key in
     * @param key the key to search from keyType's column
     * @return results from the query
     * @throws SQLException
     */
    public static ResultSet getSQLQuery(String value, String table,
            String keyType, String key) throws SQLException {
        String query = "SELECT `";
        query += value;
        query += "` FROM `";
        query += table;
        query += "` WHERE `";
        query += keyType;
        query += "` = ";
        query += key;
        Statement st = server_connections.ConnectionManager.
                getConnection().createStatement();
        ResultSet results = st.executeQuery(query);
        return results;
    }

    /**
     * Adds a row via an SQL update.
     *
     * @param table the table to update
     * @param keys which types of values will be inserted
     * @param values the values themselves to be inserted
     * @return a row count
     * @throws SQLException
     */
    public static int setSQLUpdate(String table, String keys, String values)
            throws SQLException {
        String update = "INSERT INTO `";
        update += table;
        update += "` (";
        update += keys;
        update += ") VALUES (";
        update += values;
        update += ")";
        Statement st = server_connections.ConnectionManager.
                getConnection().createStatement();
        int rowCount = st.executeUpdate(update);
        return rowCount;
    }

    private SQLStatements() {
    }
}
