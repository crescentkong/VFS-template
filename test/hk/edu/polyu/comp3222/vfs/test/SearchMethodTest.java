package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.command.SearchMethod;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static org.junit.Assert.assertTrue;

/**
 * Created by Crescent Kong on 09-Apr-17.
 */
public class SearchMethodTest {
    private final Path searchedFile = null;
    SearchMethod search = new SearchMethod(searchedFile);
    BasicFileAttributes a;
    IOException exc;
    @Test
    public void visitFile() throws Exception {
        try {
            assertTrue(search.visitFile("/Users/Public/COMP3222/test.zip", a) == FileVisitResult.CONTINUE);
        }
        catch (Exception e){
        }
    }

    @Test
    public void postVisitDirectory() throws Exception {
        try {
            assertTrue(search.postVisitDirectory("/Users/Public/COMP3222/test.zip", exc) == FileVisitResult.CONTINUE);
        }
        catch (Exception e){
        }
    }

    @Test
    public void preVisitDirectory() throws Exception {
        try {
            assertTrue(search.preVisitDirectory("/Users/Public/COMP3222/test.zip", a) == FileVisitResult.CONTINUE);
        }
        catch (Exception e){
        }
    }

    @Test
    public void visitFileFailed() throws Exception {
        try {
            assertTrue(search.visitFileFailed("/Users/Public/COMP3222/test.zip", exc) == FileVisitResult.CONTINUE);
        }
        catch (Exception e){
        }

    }

}