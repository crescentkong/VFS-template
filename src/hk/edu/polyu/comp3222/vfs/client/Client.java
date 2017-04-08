package hk.edu.polyu.comp3222.vfs.client;

import java.io.*;
import java.net.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.lang.*;
import java.util.Scanner;

class Client {
    public static void main(String argv[]) throws Exception {
        String sentence,sentence1;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
        BufferedReader inFromUser1 = new BufferedReader( new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 4003);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        DataOutputStream outToServer1 = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Console console = System.console();
        String username = console.readLine("Enter your Username :");
        char pswd[] = console.readPassword("Enter your Password :");
        String upwd=new String(pswd);
        outToServer.writeBytes(username + '\n');
        outToServer1.writeBytes(upwd + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}
