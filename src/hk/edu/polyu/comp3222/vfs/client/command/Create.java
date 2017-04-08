package hk.edu.polyu.comp3222.vfs.client.command;
import hk.edu.polyu.comp3222.vfs.client.FunctionManager;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class Create extends FunctionManager {

    public Create(){
        super();
    }

    @Override
    public void ope() throws IOException{
        VirDiskPath = read_path();
        /* Specify the path to the ZIP File that you want to read as a File System */
        //URI zipFile = URI.create("jar:file:/home.zip");
        //URI zipFile = URI.create("jar:file:/Users/Public/COMP3222/home2.zip");
        URI zipFile = URI.create(VirDiskPath);
        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(zipFileSys.getPath("/"));) {
                for (Path file : directoryStream) {
                    System.out.println(file.getFileName());
                }
                //ZipOutputStream emptyzip = new ZipOutputStream(new FileOutputStream(new FileOutputStream(tempVirDiskPath)));
                //emptyzip.close();
            }
        }
    }
}