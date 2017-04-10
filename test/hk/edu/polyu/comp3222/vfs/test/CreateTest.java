package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.Create;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class CreateTest {
    @Test
    public void ope() throws Exception {
        Create create = new Create();
        try {
            assertTrue(create.ope("Create /Users/Public/COMP3222/home121212.zip") == "Success");
        }
        catch (Exception e){
        }

    }

}