package hk.edu.polyu.comp3222.vfs.core.command;
import hk.edu.polyu.comp3222.vfs.core.DirManager;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExportDir extends DirManager {

    public ExportDir(){
        super();
    }

    public void ope() throws IOException {
        String destinationPath;
        Path ZipFilePath1;
        VirDiskPath = read_path();
        URI zipFile = URI.create(VirDiskPath);

        System.out.println("Enter the directory that you want to Export: (e.g. cheer)");
        tempAddNewFile = keyRead.readLine(); //happy.doc OR asas/a.doc

        System.out.println("Enter the destination Path: (e.g. C:\\Users\\Public\\COMP3222)");
        destinationPath = keyRead.readLine(); //C:\Users\Public\COMP3222
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