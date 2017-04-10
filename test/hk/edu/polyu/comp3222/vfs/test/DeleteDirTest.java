package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.DeleteDir;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class DeleteDirTest {
    @Test
    public void ope() throws Exception {
        DeleteDir deleteDir = new DeleteDir();
        try {
            assertTrue(deleteDir.ope("DeleteDir /Users/Public/COMP3222/home121212.zip abcfolder") == "Success");
        }
        catch (Exception e){
        }
    }

}