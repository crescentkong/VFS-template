package hk.edu.polyu.comp3222.vfs.client.command;
import hk.edu.polyu.comp3222.vfs.client.DirManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class AddDir extends DirManager {

    public AddDir(){
        super();
    }

    @Override
    public void ope() throws IOException {
        VirDiskPath = read_path();
        /* Specify the path to the ZIP File that you want to read as a File System */
        //URI zipFile = URI.create("jar:file:/home.zip");
        //URI zipFile = URI.create("jar:file:/Users/Public/COMP3222/home2.zip");
        URI zipFile = URI.create(VirDiskPath);
        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            System.out.println("Enter the name of the New Directory: (e.g. new OR asas/new)");
            tempAddNewDir = keyRead.readLine();
            //Path path = zipFileSys.getPath("docs");
            Path path = zipFileSys.getPath(tempAddNewDir);
            Files.createDirectory(path);
        }
    }
}