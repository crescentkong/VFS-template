package hk.edu.polyu.comp3222.vfs.server;

import hk.edu.polyu.comp3222.vfs.client.Account;
import hk.edu.polyu.comp3222.vfs.client.ManageAccount;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Fiona on 4/8/2017.
 */
public class Server {
    static ServerSocket hostSocket;

    static Socket sockForClient;
    static OutputStream clientOstream;
    static InputStream clientIstream;

    static Socket sockForCore;
    static OutputStream coreOstream;
    static InputStream coreIstream;

    public static String login = "false";
    public static String wrongInput = "true";

    static final int port2000 = 2000;
    static final int port3000 = 3000;

    public static Account ac;

    public static void initialClient()throws Exception{
        System.out.print("initial client");
        hostSocket =  new ServerSocket(port2000);
        sockForClient = hostSocket.accept( );
        clientOstream = sockForClient.getOutputStream();
        clientIstream  = sockForClient.getInputStream();

        while(login.equals("false")) {
            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter pwrite = new PrintWriter(clientOstream, true);

            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(clientIstream));

            String loginMesssage = "Welcome! Please input 'Login' to login the system/ 'New' to create a new account :) ";

            pwrite.println(loginMesssage);
            pwrite.flush();

            String receiveLoginMessage;
            if ((receiveLoginMessage = receiveRead.readLine()) != null) //receive from server
            {
                System.out.print("Message from client: ");
                System.out.println(receiveLoginMessage); // displaying at DOS prompt
            }

            if (receiveLoginMessage.equals("New")) {
                pwrite.println("Enter your username! ");
                String id = receiveRead.readLine();
                String pw = " ";
                ac = new Account(id, pw);
                if (ManageAccount.checkExist(ac)) {
                    pwrite.println("Username is used! Please Try Again Later.");
                    System.exit(0);
                } else {
                    pwrite.println("Enter your password! ");
                    pw = receiveRead.readLine();
                    ac = new Account(id, pw);
                    ManageAccount.createAcc(ac);
                    pwrite.println("Account is created! You can now continue to access the system. Please Enter the command!");
                    wrongInput = "false";
                    login = "true";
                }
            }

            if (receiveLoginMessage.equals("Login")) {
                pwrite.println("Enter your username! ");
                String id = receiveRead.readLine();
                pwrite.println("Enter your password! ");
                String pw = receiveRead.readLine();
                ac = new Account(id, pw);
                if (ManageAccount.login(ac)) {
                    pwrite.println("Login successfully! Please Enter the command!");
                    wrongInput = "false";
                    login = "true";
                } else {
                    pwrite.println("Username/ password is not correct! Please Try Again Later.");
                    System.out.print("Please Restart the System Again");
                    System.exit(0);

                }
            }

            if (receiveLoginMessage.equals("CloseSystem")) {
                System.out.print("System is Closed");
                System.exit(0);
            }
        }

    }

    public static void initialCore()throws Exception{
        sockForCore = new Socket("127.0.0.1", port3000);
        coreOstream = sockForCore.getOutputStream();
        coreIstream  = sockForCore.getInputStream();
    }
    public static String connectCore(String inputFromUser) throws Exception{


        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pwrite = new PrintWriter(coreOstream, true);

        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(coreIstream));

        System.out.println("Start the chitchat, type and press Enter key");


        pwrite.println(inputFromUser);
        //pwrite.println("[done]");

        pwrite.flush();
        //int flag = 1;
        String receiveMessage, sendMessage;


        while(true)
        {

            if((receiveMessage = receiveRead.readLine()) != null) //receive from server
            {
                System.out.print("Message from core: ");
                System.out.println(receiveMessage); // displaying at DOS prompt
                if (receiveMessage.equals("CloseSystem")) {
                    System.out.print("System is Closed");
                    System.exit(0);
                }
                return receiveMessage;
            }

            // start command line interface
            //cli.start(receiveMessage);

        }

    }
    public static void connectClient() throws Exception{


        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pwrite = new PrintWriter(clientOstream, true);

        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(clientIstream));

        System.out.println("Start the chitchat, type and press Enter key");


        //int flag = 1;
        String receiveMessage, sendMessage;


        while(true)
        {

            if((receiveMessage = receiveRead.readLine()) != null) //receive from server
            {
                System.out.print("Message from client: ");
                System.out.println(receiveMessage); // displaying at DOS prompt
            }

            // start command line interface
            //cli.start(receiveMessage);
            System.out.println("/////////this is the last sentence in main()");

            String messsage = connectCore(receiveMessage);

            pwrite.println(messsage + "! Please Enter Command!");
            //pwrite.println("[done]");

            pwrite.flush();

        }

    }
    public static void main(String[] args) throws Exception
    {
        initialClient();
        initialCore();
        while(true){
            connectClient();


        }
    }
}