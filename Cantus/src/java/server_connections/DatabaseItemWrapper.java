package server_connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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
        return SQLStatements.selectWhere(propertyName, getTableName(),
                getIDColumnName(), Integer.toString(getID()));
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
        return SQLStatements.insert(getTableName(), properties);
    }

    protected int setProperty(String name, String value) throws SQLException {
        return SQLStatements.executeUpdate("UPDATE " + getTableName() + " SET "
                + name + " = " + value + " WHERE " + getIDColumnName() + " = "
                + getID());
    }
}
