/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login_handling;

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
        userAdded = instance.addUser(username, password);
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
        String result = instance.getUser(username, password).getUsername();
        assertEquals(expResult, result);
    }
}
