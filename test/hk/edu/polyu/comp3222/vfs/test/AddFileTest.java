package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.AddFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class AddFileTest {
    @Test
    public void ope() throws Exception {
        AddFile addFile = new AddFile();
        try {
            assertTrue(addFile.ope("AddFile /Users/Public/COMP3222/home121212.zip abc.doc") == "Success");
        }
        catch (Exception e){
        }
    }
}