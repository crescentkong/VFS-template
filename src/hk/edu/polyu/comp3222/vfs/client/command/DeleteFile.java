package hk.edu.polyu.comp3222.vfs.client.command;
import hk.edu.polyu.comp3222.vfs.client.FileManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeleteFile extends FileManager {

    public DeleteFile(){
        super();
    }

    @Override
    public void ope() throws IOException {
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        try (FileSystem zipfs = FileSystems.newFileSystem(zipFile, attributesFalse)) {

            System.out.println("Enter the name of the File to be deleted: (e.g. happy.doc OR asas/happy.doc)");
            tempDeleteFile = keyRead.readLine();

            /* Get the Path inside ZIP File to delete the ZIP Entry */
            //Path pathInZipfile = zipfs.getPath("TESTER.doc");
            Path pathInZipfile = zipfs.getPath(tempDeleteFile);
            System.out.println("About to delete an entry from ZIP File" + pathInZipfile.toUri());
            /* Execute Delete */
            Files.delete(pathInZipfile);
            System.out.println("File successfully deleted");
        }
    }
}