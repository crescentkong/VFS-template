package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.Searching;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class SearchingTest {
    @Test
    public void ope() throws Exception {
        Searching searching = new Searching();
        try {
            assertTrue(searching.ope("Searching /Users/Public/COMP3222/home121212.zip Folder abc.doc 1 3") == "Success");
        }
        catch (Exception e){
        }
    }

}