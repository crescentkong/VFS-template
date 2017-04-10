package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.List;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class ListTest {
    @Test
    public void ope() throws Exception {
        List list = new List();
        try {
            assertTrue(list.ope("List /Users/Public/COMP3222/home121212.zip") == "Success");
        }
        catch (Exception e){
        }

    }

}