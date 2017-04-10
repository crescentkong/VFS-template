package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.CopyDir;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class CopyDirTest {
    @Test
    public void ope() throws Exception {
        CopyDir copyDir = new CopyDir();
        try {
            assertTrue(copyDir.ope("CopyDir /Users/Public/COMP3222/home121212.zip abcfd abc1") == "Success");
        }
        catch (Exception e){
        }
    }

}