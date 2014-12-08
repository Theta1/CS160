package server_connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
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
    private static ResultSet executeQuery(String query)
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
     * Deletes a row.
     *
     * @param table the table of the row
     * @param whereKey a column to use to find the row
     * @param whereValue the cell that intersects whereKey and the desired row.
     * @return a row count
     * @throws SQLException
     */
    public static int delete(String table, String whereKey,
            String whereValue) throws SQLException {
        return executeUpdate("DELETE " + from(table) + " " + where(whereKey,
                whereValue));
    }

    /**
     * Returns results from an SQL query. SELECT value FROM table WHERE keyType
     * = key;
     *
     * @param selection the value to get from the row
     * @param table the table to use for the query
     * @param whereKey the row name to look for the key in
     * @param whereValue the key to search from keyType's column
     * @return results from the query
     * @throws SQLException
     */
    public static ResultSet selectWhere(String selection, String table,
            String whereKey, String whereValue) throws SQLException {
        return executeQuery("SELECT " + selection + " " + from(table) + " "
                + where(whereKey, whereValue));
    }

    /**
     * Returns results from an SQL query. SELECT selection FROM table
     *
     * @param selection the value to get from the rows
     * @param table the table to use for the query
     * @return results from the query
     * @throws SQLException
     */
    public static ResultSet select(String selection, String table)
            throws SQLException {
        return executeQuery("SELECT " + selection + " " + from(table));
    }

    /**
     * Sends an SQL update.
     *
     * @param update the SQL statement to send
     * @return a row count
     * @throws SQLException
     */
    private static int executeUpdate(String update) throws SQLException {
        return createStatement().executeUpdate(update);
    }

    /**
     *
     * @param table the name of the table
     * @return FROM table
     */
    private static String from(String table) {
        return "FROM `" + table + "`";
    }

    /**
     *
     * @param table the name of the table
     * @return INTO table
     */
    private static String into(String table) {
        return "INTO `" + table + "`";
    }

    /**
     * Adds a row via an SQL update.
     *
     * @param table the table to update
     * @param insertions a map of the properties to their values
     * @return a row count
     * @throws SQLException
     */
    public static int insert(String table, Map<String, String> insertions)
            throws SQLException {
        String keys = "";
        String values = "";
        Iterator<Map.Entry<String, String>> it = insertions.entrySet()
                .iterator();
        int i = 0;
        while (it.hasNext()) {
            // Add comma if not first entry.
            Map.Entry<String, String> nextEntry = it.next();
            if (i > 0) {
                keys += ", ";
                values += ", ";
            }
            keys += "`";
            keys += nextEntry.getKey();
            keys += "`";
            values += nextEntry.getValue();
            ++i;
        }
        return SQLStatements.executeUpdate("INSERT " + into(table) + " ("
                + keys + ") VALUES (" + values + ")");
    }

    /**
     *
     * @param key column name
     * @param value value of cell
     * @return WHERE key = value
     */
    private static String where(String key, String value) {
        return "WHERE `" + key + "` = " + value;
    }

    private static String set(Map<String, String> assignments) {
        String sql = "SET ";
        int i = 0;
        Iterator<Map.Entry<String, String>> it = assignments.entrySet()
                .iterator();
        while (it.hasNext()) {
            // Add comma if not first entry.
            if (i > 0) {
                sql += ", ";
            }
            Map.Entry<String, String> nextEntry = it.next();
            sql += nextEntry.getKey() + " = " + nextEntry.getValue();
            ++i;
        }
        return sql;
    }

    /**
     * Updates an existing row.
     *
     * @param table the table to update
     * @param assignments a map of the value to update
     * @param whereKey the column to search
     * @param whereValue the row to select
     * @return a row count
     * @throws SQLException
     */
    public static int updateSet(String table, Map<String, String> assignments,
            String whereKey, String whereValue) throws SQLException {
        return executeUpdate("UPDATE " + table + " " + set(assignments)
                + " WHERE " + whereKey + " = " + whereValue);
    }

    private SQLStatements() {
    }
}
