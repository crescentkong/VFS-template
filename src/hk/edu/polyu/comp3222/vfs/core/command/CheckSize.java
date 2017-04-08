package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FileManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class CheckSize extends FileManager {

    public CheckSize(){
        super();
    }

    @Override
    public void ope() throws IOException {
        System.out.println("Enter the path of the Virtual Disk: (e.g./Users/Public/COMP3222/home2.zip)");
        tempVirDiskPath = keyRead.readLine();
        File file = new File(tempVirDiskPath.toString());

        ZipInputStream zis = null;

        FileInputStream fis = new FileInputStream(tempVirDiskPath);
        int size = fis.available();
        System.out.println("size in KB : " + (int) Math.ceil(size/1024.0));
        zis = new ZipInputStream(fis);
    }
}