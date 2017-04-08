package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.FileManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MoveFile extends FileManager {

    public MoveFile(){
        super();
    }

    @Override
    public void ope() throws IOException {
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            System.out.println("Enter the path of the File to be moved: (e.g. reallweeks.png)");
            tempDeleteFile = keyRead.readLine();
            Path ZipFilePath = zipFileSys.getPath(tempDeleteFile);
            System.out.println("Enter the new path of the File: (e.g. a/reallweeks.png)");
            tempAddNewFile = keyRead.readLine();
            Path ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            Files.copy(ZipFilePath, ZipFilePath1);
            Files.delete(ZipFilePath);
        }
    }
}