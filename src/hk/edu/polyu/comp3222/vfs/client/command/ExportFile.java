package hk.edu.polyu.comp3222.vfs.client.command;
import hk.edu.polyu.comp3222.vfs.client.FileManager;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExportFile extends FileManager {

    public ExportFile(){
        super();
    }

    public void ope() throws IOException {
        String destinationPath;
        Path ZipFilePath1;
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        System.out.println("Enter the file that you want to Export: (e.g. happy.doc OR asas/a.doc)");
        tempAddNewFile = keyRead.readLine(); //happy.doc OR asas/a.doc

        System.out.println("Enter the destination Path: (e.g. C:\\Users\\Public)");
        destinationPath = keyRead.readLine(); //C:\Users\Public
        if (tempAddNewFile.matches("(.*)" + "(/)"+ "(.*)"))
            destinationPath = destinationPath + "/" + tempAddNewFile.substring(tempAddNewFile.lastIndexOf("/") +1,tempAddNewFile.length()) ;
        else destinationPath = destinationPath + "/" + tempAddNewFile;
        File source = new File(destinationPath);

        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            ZipFilePath1 = zipFileSys.getPath(tempAddNewFile);
            Files.copy(ZipFilePath1, source.toPath());
        }
    }
}