package server_connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Wraps a database item using an ID number.
 *
 * @author Christopher Raleigh
 * @author Benjamin Ngo
 * @author Jeremy Wong
 * @author David-Eric Thorpe
 */
public abstract class DatabaseItemWrapper {

    /**
     *
     * @return the primary key of the item
     */
    protected abstract int getID();

    /**
     *
     * @return the name of the table where this item is located
     */
    protected abstract String getTableName();

    /**
     *
     * @return the column name of the table's primary keys
     */
    protected abstract String getIDColumnName();

    /**
     * Returns results from an SQL query for the specified property.
     *
     * @param propertyName the column name of the property to return
     * @return a result set that has the requested property
     * @throws SQLException
     */
    protected ResultSet getProperty(String propertyName) throws
            SQLException {
        String table = getTableName();
        String keyType = getIDColumnName();
        String key = Integer.toString(getID());
        String query = "SELECT `" + propertyName + "` FROM `" + table + "` WHERE `" + keyType + "` = " + key;
        ResultSet results = SQLStatements.selectWhere(propertyName, table,
                keyType, key);
        return results;
    }

    /**
     * Adds a new row to the database table
     *
     * @param properties
     * @return the row count
     * @throws SQLException
     */
    protected int addAsRow(Map<String, String> properties) throws
            SQLException {
        String table = getTableName();
        String keys = "";
        String values = "";
        Iterator<Entry<String, String>> it = properties.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            // Add comma if not first entry.
            Entry<String, String> nextEntry = it.next();
            if (i > 0) {
                String comma = ", ";
                keys += comma;
                values += comma;
            }
            String apostrophe = "`";
            keys += apostrophe;
            keys += nextEntry.getKey();
            keys += apostrophe;
            values += nextEntry.getValue();
            ++i;
        }
        String update = "INSERT INTO `" + table + "` (" + keys + ") VALUES ("
                + values + ")";
        int rowCount = SQLStatements.executeUpdate(update);
        return rowCount;
    }
}
