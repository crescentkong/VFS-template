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
//       try {
//            assertTrue(virtualDisk.getFieldData("Create /Users/Public/COMP3222/test11.zip", 2, " ") == "Success");
//        }
//        catch (Exception e){
//        }
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