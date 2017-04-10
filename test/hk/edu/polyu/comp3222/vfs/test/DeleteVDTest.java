package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.DeleteVD;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class DeleteVDTest {
    @Test
    public void ope() throws Exception {
        DeleteVD deleteVD = new DeleteVD();
        try {
            assertTrue(deleteVD.ope("DeleteVD /Users/Public/COMP3222/home121212.zip") == "Success");
        }
        catch (Exception e){
        }
    }
}