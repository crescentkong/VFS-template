package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.VirtualDisk;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class VirtualDiskTest {
    VirtualDisk virtualDisk = new VirtualDisk();
    /**
     * @throws Exception
     */
    @Test
    public void getFieldData() throws Exception {
        VirtualDisk virtualDisk = new VirtualDisk();
        try {
            assertTrue(virtualDisk.getFieldData("DeleteFile /Users/Public/COMP3222/home121212.zip abc.doc", 3, " ") == "Success");
            assertTrue(virtualDisk.getFieldData("DeleteFile /Users/Public/COMP3222/home121212.zip abc.doc", 4, " ") == "Success");
        }
        catch (Exception e){
        }
    }

    @Test
    public void strategy() throws Exception {
        try {
            assertTrue(virtualDisk.strategy("Copy") == "Success");
        }
        catch (Exception e){
        }
    }
}