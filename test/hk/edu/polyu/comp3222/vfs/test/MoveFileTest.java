package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.MoveFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class MoveFileTest {
    @Test
    public void ope() throws Exception {
        MoveFile moveFile = new MoveFile();
        try {
            assertTrue(moveFile.ope("MoveFile /Users/Public/COMP3222/home121212.zip abcd.doc abcfolder/abcd.doc") == "Success");
        }
        catch (Exception e){
        }
    }

}