/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login_handling;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Christopher Raleigh
 */
public class UserDatabaseTest {

    private static UserDatabase instance;
    private static String username;
    private static String password;
    private static boolean userAdded;

    public UserDatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new UserDatabase();
        username = "CRaleigh";
        password = "password";
        try {
            userAdded = instance.signUp(username, password);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Test of addUser method, of class UserDatabase.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        boolean expResult = true;
        boolean result = userAdded;
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class UserDatabase.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String expResult = username;
        String result;
        try {
            result = instance.logIn(username, password).getUsername();
            assertEquals(expResult, result);
        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }
}
