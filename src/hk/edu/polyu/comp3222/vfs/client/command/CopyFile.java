package hk.edu.polyu.comp3222.vfs.client.command;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import hk.edu.polyu.comp3222.vfs.client.FileManager;

public class CopyFile extends FileManager {

    public CopyFile(){
        super();
    }

    @Override
    public void ope() throws IOException {
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            System.out.println("Enter the path of the File to be copied: (e.g. happy.doc)");
            tempDeleteFile = keyRead.readLine(); //happy.doc
            Path ZipFilePath = zipFileSys.getPath(tempDeleteFile);
            System.out.println("Enter the path of the copied File: (e.g. happy2.doc OR asas/happy.doc)");
            tempAddNewFile = keyRead.readLine(); //happy2.doc OR asas/happy.doc
            Path ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            Files.copy(ZipFilePath, ZipFilePath1);
        }
    }
}