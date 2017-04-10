package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.ExportFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class ExportFileTest {

    @Test
    public void ope() throws Exception {
        ExportFile exportFile = new ExportFile();
        try {
            assertTrue(exportFile.ope("ExportFile /Users/Public/COMP3222/home121212.zip allweeks.png C:\\Users\\Public") == "Success");
        }
        catch (Exception e){
        }
    }

}