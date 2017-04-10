package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.DeleteFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class DeleteFileTest {
    @Test
    public void ope() throws Exception {
        DeleteFile deleteFile = new DeleteFile();
        try {
            assertTrue(deleteFile.ope("DeleteFile /Users/Public/COMP3222/home121212.zip abc.doc") == "Success");
        }
        catch (Exception e){
        }
    }

}