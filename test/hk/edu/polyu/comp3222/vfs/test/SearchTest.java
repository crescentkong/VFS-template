package hk.edu.polyu.comp3222.vfs.test;

import org.junit.Test;
import hk.edu.polyu.comp3222.vfs.core.command.Search;

import java.io.File;
import java.nio.file.FileVisitResult;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class SearchTest {
   // Search search = new Search();

    @Test
    public void visitFile() throws Exception {
       // assertTrue(search.visitFile(file) == FileVisitResult.CONTINUE);
    }

    @Test
    public void postVisitDirectory() throws Exception {

    }

    @Test
    public void preVisitDirectory() throws Exception {

    }

    @Test
    public void visitFileFailed() throws Exception {

        try {
        //    assertTrue(search.visitFileFailed("CheckSize /Users/Public/COMP3222/home121212.zip") == FileVisitResult.CONTINUE);
        }
        catch (Exception e){
        }

    }

}