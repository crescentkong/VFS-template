package hk.edu.polyu.comp3222.vfs.client;

import hk.edu.polyu.comp3222.vfs.client.command.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Shell {
    public static String tempCaseSensitive = "1";
    public static String tempMatchAllKeywords = "1";

    //reading from keyboard (keyRead object)
    public static BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

    public static String tempVirDiskPath = "jar:file:/Users/Public/COMP3222/home.zip";
    public static String VirDiskPath = "jar:file:/Users/Public/COMP3222/home.zip";
    public static String searchPath = "jar:file:/Users/Public/COMP3222/home.zip";
    public static String tempSearchPath = "jar:file:/Users/Public/COMP3222/home.zip";
    public static String tempAddNewFile = "testing.doc";
    public static String tempAddNewDir = "testingdir";
    public static String tempDeleteFile = "testing.doc";
    public static String tempDeleteDir = "testingdir";
    public static String tempDeleteVDisk =  "jar:file:/Users/Public/COMP3222/home.zip";
    public static String tempSearchWord = "testing.doc";
    public static String tempSearchFileFolder = "File";
    public static String command = "Create";
    public static String tempEntry = "a/";

    /* Define ZIP File System Properies in HashMap */
    public static Map<String, String> attributes = new HashMap<>();
    public static Map<String, String> attributesFalse = new HashMap<>();

    public Shell(){

        attributes.put("create", "true");
        /* We want to read an existing ZIP File, so we set this to False */
        attributesFalse.put("create", "false");
    }

    public void read_command() throws IOException {
        while(true){
            System.out.println("Enter the command you want to execute: ");
            command = keyRead.readLine();
            System.out.println(command);

            if (command.equals("Create")) {
                (new Create()).ope();
            }

            if (command.equals("AddFile")) {
                (new AddFile()).ope();
            }

            if (command.equals("DeleteFile")) {
                (new DeleteFile()).ope();
            }

            if (command.equals("AddDir")) {
                (new AddDir()).ope();
            }

            if (command.equals("DeleteDir")) {
                (new DeleteDir()).ope();
            }

            if (command.equals("Delete")) {
                (new Delete()).ope();
            }

            if (command.equals("List")) {
                (new List()).ope();
            }

//            if (command.equals("Search")) {
//                (new Searching()).ope();
//            }

            if (command.equals("CheckSize")) {
                (new CheckSize()).ope();
            }

            if (command.equals("CopyFile")) {
                (new CopyFile()).ope();
            }

            if (command.equals("RenameFile")) {
                (new RenameFile()).ope();
            }

            if (command.equals("MoveFile")) {
                (new MoveFile()).ope();
            }

            if (command.equals("ImportFile")) {
                (new ImportFile()).ope();
            }

            if (command.equals("ExportFile")) {
                (new ExportFile()).ope();
            }
        }
    }
}