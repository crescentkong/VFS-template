package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.ImportFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class ImportFileTest {
    @Test
    public void ope() throws Exception {
        ImportFile importFile = new ImportFile();
        try {
            assertTrue(importFile.ope("ImportFile C:\\Users\\Public\\COMP3222\\allweeks.png /Users/Public/COMP3222/home121212.zip allweeks.png") == "Success");
        }
        catch (Exception e){
        }
    }

}