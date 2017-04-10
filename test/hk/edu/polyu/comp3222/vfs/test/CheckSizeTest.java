package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.CheckSize;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class CheckSizeTest {
    @Test
    public void ope() throws Exception {
        CheckSize checkSize = new CheckSize();
        try {
            assertTrue(checkSize.ope("CheckSize /Users/Public/COMP3222/home121212.zip") == "Success");
        }
        catch (Exception e){
        }
    }

}