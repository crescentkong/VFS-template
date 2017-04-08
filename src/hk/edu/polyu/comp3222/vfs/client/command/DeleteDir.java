package hk.edu.polyu.comp3222.vfs.client.command;
import hk.edu.polyu.comp3222.vfs.client.DirManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeleteDir extends DirManager {

    public DeleteDir(){
        super();
    }

    public void ope() throws IOException {
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            System.out.println("Enter the name of Directory to be deleted: (e.g. reasas)"); //cannot delete directory with files inside
            tempDeleteVDisk = keyRead.readLine();
            //Path path = zipFileSys.getPath("docs");
            Path pathInZipfile = zipFileSys.getPath(tempDeleteVDisk);
            System.out.println("About to delete a directory from ZIP File" + pathInZipfile.toUri() );
                    /* Execute Delete */
            Files.delete(pathInZipfile);
            System.out.println("Directory successfully deleted");
        }
    }
}