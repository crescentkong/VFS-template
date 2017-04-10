package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.RenameDir;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class RenameDirTest {
    @Test
    public void ope() throws Exception {
        RenameDir renameDir = new RenameDir();
        try {
            assertTrue(renameDir.ope("RenameDir /Users/Public/COMP3222/home121212.zip abc1 abc") == "Success");
        }
        catch (Exception e){
        }
    }

}