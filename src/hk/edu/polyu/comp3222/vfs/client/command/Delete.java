package hk.edu.polyu.comp3222.vfs.client.command;
import hk.edu.polyu.comp3222.vfs.client.FunctionManager;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Delete extends FunctionManager {

    public Delete(){
        super();
    }

    @Override
    public void ope() throws IOException {
        System.out.println("Enter the path of the Virtual Disk to be Deleted: (e.g./Users/Public/COMP3222/home2.zip)");

        tempVirDiskPath = keyRead.readLine();
        File file = new File(tempVirDiskPath.toString());
        boolean deleted = file.delete();
        if (deleted){
            System.out.println("About to delete an entry from ZIP File" + tempVirDiskPath.toString());
            System.out.println("File successfully deleted");
        }
    }
}