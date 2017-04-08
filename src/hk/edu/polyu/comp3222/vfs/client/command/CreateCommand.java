package hk.edu.polyu.comp3222.vfs.client.command;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class CreateCommand {
    public static void main(String[] args) throws Exception {
        /* Define ZIP File System Properies in HashMap */
        Map<String, String> attributes = new HashMap<>();
        Map<String, String> attributesFalse = new HashMap<>();
        attributes.put("create", "true");
        /* We want to read an existing ZIP File, so we set this to False */
        attributesFalse.put("create", "false");


        // reading from keyboard (keyRead object)
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        String tempVirDiskPath = "jar:file:/Users/Public/COMP3222/home.zip";
        String VirDiskPath = "jar:file:/Users/Public/COMP3222/home.zip";
        String searchPath = "jar:file:/Users/Public/COMP3222/home.zip";
        String tempSearchPath = "jar:file:/Users/Public/COMP3222/home.zip";
        String tempAddNewFile = "testing.doc";
        String tempAddNewDir = "testingdir";
        String tempDeleteFile = "testing.doc";
        String tempDeleteDir = "testingdir";
        String tempDeleteVDisk =  "jar:file:/Users/Public/COMP3222/home.zip";
        String tempSearchWord = "testing.doc";
        String tempSearchFileFolder = "File";
        String command = "Create";
        String tempEntry = "a/";

    }
}