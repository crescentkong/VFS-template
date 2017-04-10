package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.MoveFile;
import hk.edu.polyu.comp3222.vfs.core.command.RenameFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class RenameFileTest {
    @Test
    public void ope() throws Exception {
        RenameFile renameFile = new RenameFile();
        try {
            assertTrue(renameFile.ope("RenameFile /Users/Public/COMP3222/home121212.zip abc.doc reabc.doc") == "Success");
        }
        catch (Exception e){
        }
    }

}