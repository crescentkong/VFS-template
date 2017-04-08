package hk.edu.polyu.comp3222.vfs.core;

import hk.edu.polyu.comp3222.vfs.client.command.CreateCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

public class VirtualDisk {
    public String vdiskName;
    public static void main(String[] args) throws Exception {
        /* Define ZIP File System Properies in HashMap */
        Map<String, String> attributes = new HashMap<>();

        /* We want to read an existing ZIP File, so we set this to False */
        attributes.put("create", "true");

        String command = "Create";

        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the command you want to execute: ");
        command = keyRead.readLine();
        System.out.println(command);
        if (command.equals("Create")) {
            new CreateCommand();
        }
    }
}