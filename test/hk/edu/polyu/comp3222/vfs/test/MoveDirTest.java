package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.MoveDir;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class MoveDirTest {
    @Test
    public void ope() throws Exception {
        MoveDir moveDir = new MoveDir();
        try {
            assertTrue(moveDir.ope("MoveDir /Users/Public/COMP3222/home121212.zip abc abcfd/abc") == "Success");
        }
        catch (Exception e){
        }
    }

}