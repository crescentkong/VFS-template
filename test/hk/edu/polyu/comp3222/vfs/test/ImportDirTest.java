package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.ImportDir;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class ImportDirTest {
    @Test
    public void ope() throws Exception {
        ImportDir importDir = new ImportDir();
        try {
            assertTrue(importDir.ope("ImportDir C:\\Users\\Public\\COMP3222\\abc /Users/Public/COMP3222/home121212.zip abc") == "Success");
        }
        catch (Exception e){
        }
    }

}