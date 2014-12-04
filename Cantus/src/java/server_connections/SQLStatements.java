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
     * @param query the SQL statement to send
     * @return results from the query
     * @throws SQLException
     */
    public static ResultSet executeQuery(String query)
            throws SQLException {
        return createStatement().executeQuery(query);
    }

    /**
     *
     * @return a new statement
     * @throws SQLException
     */
    private static Statement createStatement() throws SQLException {
        return server_connections.ConnectionManager.getConnection()
                .createStatement();
    }

    /**
     * Returns results from an SQL query. SELECT value FROM table WHERE keyType
     * = key;
     *
     * @param value the value to get from the row
     * @param table the table to use for the query
     * @param keyType the row name to look for the key in
     * @param key the key to search from keyType's column
     * @return results from the query
     * @throws SQLException
     */
    public static ResultSet selectWhere(String value, String table,
            String keyType, String key) throws SQLException {
        String query = "SELECT `";
        query += value;
        query += "` FROM `";
        query += table;
        query += "` WHERE `";
        query += keyType;
        query += "` = ";
        query += key;
        ResultSet results = executeQuery(query);
        return results;
    }

    /**
     * Returns results from an SQL query. SELECT value FROM table
     *
     * @param value the value to get from the rows
     * @param table the table to use for the query
     * @return results from the query
     * @throws SQLException
     */
    public static ResultSet select(String value, String table)
            throws SQLException {
        String query = "SELECT `";
        query += value;
        query += "` FROM `";
        query += table;
        query += "`";
        ResultSet results = executeQuery(query);
        return results;
    }

    /**
     * Sends an SQL update.
     *
     * @param update the SQL statement to send
     * @return a row count
     * @throws SQLException
     */
    public static int executeUpdate(String update)
            throws SQLException {
        return createStatement().executeUpdate(update);
    }

    private SQLStatements() {
    }
}
