package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.DirManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MoveDir extends DirManager {

    public MoveDir(){
        super();
    }

    public void ope() throws IOException {
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            System.out.println("Enter the name of the Directory to be moved: ");
            tempDeleteDir = keyRead.readLine();
            Path ZipFilePath = zipFileSys.getPath(tempDeleteDir);
            System.out.println("Enter the destinaton path: ");
            tempAddNewDir = keyRead.readLine();
            Path ZipFilePath1 = zipFileSys.getPath(tempAddNewDir);
            Files.createDirectory(ZipFilePath1);
            Files.delete(ZipFilePath);
        }
    }
}