package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.client.Account;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class AccountTest {

    @Test
    public void getId() throws Exception {
        Account ac = new Account("abc", "def");
        assertEquals("abc", ac.getId());
    }

    @Test
    public void getPw() throws Exception {
        Account ac = new Account("abc", "def");
        assertEquals("def", ac.getPw());
    }

    @Test
    public void testhashCode() throws Exception {
        Account ac = new Account("admin", "admin");
        Account ac1 = new Account("admin", "admin");
        Account ac2 = new Account("admin", "admin1");
        assertEquals(ac.hashCode(), ac1.hashCode());
        assertNotSame(ac.hashCode(), ac2.hashCode());
    }

    @Test
    public void equals() throws Exception {
        Account ac = new Account("admin", "admin");
        Account ac1 = new Account("admin", "admin");
        Account ac2 = new Account("admin", "admin1");
        assertTrue(ac.equals(ac1));
        assertFalse(ac.equals(ac2));
        assertFalse(ac.equals(null));
    }

}