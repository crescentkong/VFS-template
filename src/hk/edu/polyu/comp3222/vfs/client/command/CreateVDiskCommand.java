package hk.edu.polyu.comp3222.vfs.client.command;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class CreateVDiskCommand  {
    public static void main(String[] args) throws Exception {
        /* Define ZIP File System Properies in HashMap */
        Map<String, String> attributes = new HashMap<>();

        /* We want to read an existing ZIP File, so we set this to False */
        attributes.put("create", "true");

        // reading from keyboard (keyRead object)
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        /* Specify the path to the ZIP File that you want to read as a File System */
        URI zipFile = URI.create("jar:file:/Users/Public/COMP3222/home1.zip");

        /* Create ZIP file System */
        try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
        }
    }
}