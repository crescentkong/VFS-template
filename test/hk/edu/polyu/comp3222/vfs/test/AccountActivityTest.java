package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.client.Account;
import hk.edu.polyu.comp3222.vfs.client.AccountActivity;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 10-Apr-17.
 */
public class AccountActivityTest {
    AccountActivity m = new AccountActivity();

    @Test
    public void getAccount() throws Exception {
        assertTrue(m.login(new Account("admin", "admin")));
        assertTrue(m.getAccount() instanceof Account);
    }

    @Test
    public void checkExist() throws Exception {
        assertTrue(m.checkExist(new Account("admin", "admin")));
        assertFalse(m.checkExist(null));
        assertTrue(m.checkExist(new Account("user", "user")));
        assertFalse(m.checkExist(new Account("testing123", "testing123")));
    }

    @Test
    public void createAcc() throws Exception {
            assertTrue(m.createAcc(new Account("admin", "admin")) == "Success");
    }

    @Test
    public void login() throws Exception {
        assertTrue(m.login(new Account("admin", "admin")));
        assertEquals("admin", m.getAccount().getId());
        assertFalse(m.login(null));
        assertTrue(m.login(new Account("user", "user")));
        assertFalse(m.login(new Account("testing123", "testing123")));
    }

}