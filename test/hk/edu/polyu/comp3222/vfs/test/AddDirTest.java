package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.AddDir;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class AddDirTest {
    @Test
    public void ope() throws Exception {
        AddDir addDir = new AddDir();
        try {
            assertTrue(addDir.ope("AddDir /Users/Public/COMP3222/home121212.zip abcfolder") == "Success");
        }
        catch (Exception e){
        }
    }

}