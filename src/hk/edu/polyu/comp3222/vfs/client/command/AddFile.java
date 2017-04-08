package hk.edu.polyu.comp3222.vfs.client.command;
import hk.edu.polyu.comp3222.vfs.client.FileManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class AddFile extends FileManager {

    public AddFile(){
        super();
    }

    @Override
    public void ope() throws IOException {
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            /* Create a Path in ZIP File */
            System.out.println("Enter the path of the new File: (e.g. abc.doc OR a123/abc.doc) ");
            tempAddNewFile = keyRead.readLine();
            //Path ZipFilePath = zipFileSys.getPath("TESTER.doc");
            Path ZipFilePath = zipFileSys.getPath(tempAddNewFile);
            /* Path where the file to be added resides */
            //Path addNewFile = Paths.get("C:/Users/Public/COMP3222/home2.zip");
            Path addNewFile = Paths.get("C:" + tempVirDiskPath);
            /* Append file to ZIP File */
            Files.copy(addNewFile, ZipFilePath);
        }
    }
}