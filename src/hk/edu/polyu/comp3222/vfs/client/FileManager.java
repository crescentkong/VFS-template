package hk.edu.polyu.comp3222.vfs.client;
import java.io.IOException;

public abstract class FileManager extends Shell {

    public FileManager(){
        super();
    }

    abstract public void ope() throws IOException;

    public String read_path() throws IOException{
        System.out.println("Enter the path of the Virtual Disk:  (e.g./Users/Public/COMP3222/home2.zip)");
        tempVirDiskPath = keyRead.readLine();
        VirDiskPath = "jar:file:" + tempVirDiskPath;
        System.out.println(VirDiskPath);
        return VirDiskPath;
    }
}