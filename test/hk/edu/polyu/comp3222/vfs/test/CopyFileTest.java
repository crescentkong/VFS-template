package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.CopyFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class CopyFileTest {
    @Test
    public void ope() throws Exception {
        CopyFile copyFile = new CopyFile();
        try {
            assertTrue(copyFile.ope("CopyFile /Users/Public/COMP3222/home121212.zip abc.doc abcd.doc") == "Success");
        }
        catch (Exception e){
        }
    }

}