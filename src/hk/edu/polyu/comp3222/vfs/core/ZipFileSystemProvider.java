package hk.edu.polyu.comp3222.vfs.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class ZipFileSystemProvider {

    public static void main(String[] args) throws Exception {
        /* Define ZIP File System Properies in HashMap */
        Map<String, String> attributes = new HashMap<>();

        //attributes.put("create", "true");
        /* We want to read an existing ZIP File, so we set this to False */
        attributes.put("create", "true");


        // reading from keyboard (keyRead object)
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        //String VirDiskPath = "jar:file:/Users/Public/COMP3222/home.zip";
        //System.out.println("Enter the name of the Virtual Disk: ");
        //VirDiskPath = keyRead.readLine();
        /* Specify the path to the ZIP File that you want to read as a File System */
        //URI zipFile = URI.create("jar:file:/home.zip");
        URI zipFile = URI.create("jar:file:/Users/Public/COMP3222/home1.zip");


        /* Create ZIP file System */
        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
            /* Create a Path in ZIP File */
            Path ZipFilePath = zipFileSys.getPath("TESTER.doc");
            /* Path where the file to be added resides */
            Path addNewFile = Paths.get("C:/Users/Public/COMP3222/home1.zip");
            /* Append file to ZIP File */
            Files.copy(addNewFile,ZipFilePath);



            //Path path = zipFileSys.getPath("docs");
            //Files.createDirectory(path);

            //try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(zipFileSys.getPath("/"));) {
            //for (Path file : directoryStream) {
            //System.out.println(file.getFileName());
            //}
            //}
        }
    }
}