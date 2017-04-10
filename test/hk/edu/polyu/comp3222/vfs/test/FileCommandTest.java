package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.FileCommand;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Crescent Kong on 10-Apr-17.
 */
public class FileCommandTest {
    FileCommand fileCommand = new FileCommand() {
        @Override
        public void ope() throws IOException {
        }
    };

    @Test
    public void ope() throws Exception {
        try {
            fileCommand.ope();
        }
        catch (Exception e){
        }
    }

    @Test
    public void read_path() throws Exception {
    }

}