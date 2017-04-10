package hk.edu.polyu.comp3222.vfs.core;

import hk.edu.polyu.comp3222.vfs.core.command.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
public class VirtualDisk {
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
    public static String sourcePath ="C:\\Users\\Public\\COMP3222\\allweeks.png";
    public static String destinationPath = "C:\\Users\\Public";
    public static String tempEntry = "a/";
    public static String command = "Create";

    public static int state = 0;    // 0 = initial, 1 = mounted to virtual disk
    /* Define ZIP File System Properies in HashMap */
    public static Map<String, String> attributes = new HashMap<>();
    public static Map<String, String> attributesFalse = new HashMap<>();

    public VirtualDisk(){

        attributes.put("create", "true");
        /* We want to read an existing ZIP File, so we set this to False */
        attributesFalse.put("create", "false");
    }
    public static String getFieldData(String input, int searchNum,
                                      String delimiter) {
        try {
            String[] list = input.split(delimiter);
            return list[searchNum - 1];
        } catch (Exception e) {}
        return "Success";
    }

    public String strategy(String input) throws IOException {
        command = getFieldData(input,1," ");
        String tmp[] = input.split(" ");
        String parameter="";
        for(int i=1;i<tmp.length;i++){
            parameter+=tmp[i]+" ";
        }
        parameter = parameter.trim();

        if (command.equals("Create")) {
            (new Create()).ope(parameter);
        }

        if (command.equals("AddFile")) {
            (new AddFile()).ope(parameter);
        }

        if (command.equals("DeleteFile")) {
            (new DeleteFile()).ope(parameter);
        }

        if (command.equals("AddDir")) {
            (new AddDir()).ope(parameter);
        }

        if (command.equals("DeleteDir")) {
            (new DeleteDir()).ope(parameter);
        }

        if (command.equals("DeleteVD")) {
            (new DeleteVD()).ope(parameter);
        }

        if (command.equals("List")) {
            (new List()).ope(parameter);
        }

        if (command.equals("Searching")) {
            (new Searching()).ope(parameter);
        }

        if (command.equals("CheckSize")) {
            (new CheckSize()).ope(parameter);
        }

        if (command.equals("CopyFile")) {
            (new CopyFile()).ope(parameter);
        }

        if (command.equals("RenameFile")) {
            (new RenameFile()).ope(parameter);
        }

        if (command.equals("MoveFile")) {
            (new MoveFile()).ope(parameter);
        }

        if (command.equals("ImportFile")) {
            (new ImportFile()).ope(parameter);
        }

        if (command.equals("ExportFile")) {
            (new ExportFile()).ope(parameter);
        }

        if (command.equals("CopyDir")) {
            (new CopyDir()).ope(parameter);
        }

        if (command.equals("RenameDir")) {
            (new RenameDir()).ope(parameter);
        }

        if (command.equals("MoveDir")) {
            (new MoveDir()).ope(parameter);
        }

        if (command.equals("ImportDir")) {
            (new ImportDir()).ope(parameter);
        }

        if (command.equals("ExportDir")) {
            (new ExportDir()).ope(parameter);
        }
    return "Success";
    }
}