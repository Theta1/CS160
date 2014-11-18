/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library_handling;

import login_handling.User;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Christopher Raleigh
 */
public class MusicLibraryDatabaseTest {

    static MusicLibraryDatabase instance;

    public MusicLibraryDatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new MusicLibraryDatabase();
    }

    /**
     * Test of getMusicLibrary method, of class MusicLibraryDatabase.
     */
    @Test
    public void testGetMusicLibrary() {
        System.out.println("getMusicLibrary");
        User user = null;
        MusicLibrary expResult = null;
        MusicLibrary result = instance.getMusicLibrary(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
