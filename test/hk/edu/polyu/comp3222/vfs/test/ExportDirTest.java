package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.ExportDir;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class ExportDirTest {
    @Test
    public void ope() throws Exception {
        ExportDir exportDir = new ExportDir();
        try {
            assertTrue(exportDir.ope("ExportDir /Users/Public/COMP3222/home121212.zip abcfd C:\\Users\\Public") == "Success");
        }
        catch (Exception e){
        }
    }

}