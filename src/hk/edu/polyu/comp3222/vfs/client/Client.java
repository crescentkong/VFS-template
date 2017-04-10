package hk.edu.polyu.comp3222.vfs.client;

import hk.edu.polyu.comp3222.vfs.core.VirtualDisk;
import hk.edu.polyu.comp3222.vfs.core.command.*;
import hk.edu.polyu.comp3222.vfs.server.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Fiona on 4/8/2017.
 */
public class Client {

    private static Socket socket;

    static final int port2000 = 2000;

    public static void connectToServer() throws Exception{

        Socket sock = new Socket("127.0.0.1", port2000);
        // reading from keyboard (keyRead object)
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        // sending to client (pwrite object)
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        // receiving from server ( receiveRead  object)
        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Start the chitchat, type and press Enter key");

        //int flag = 1;
        String receiveMessage, sendMessage;

        //String replyinclass = CreateCommand.reply;
        //System.out.println(replyinclass);
        //System.out.println(replyinclass);
        while(Server.login.equals("false")){
            String receiveLoginMessage;
            if((receiveLoginMessage = receiveRead.readLine()) != null) //receive from server
            {
                System.out.print("Message from server: ");
                System.out.println(receiveLoginMessage); // displaying at DOS prompt
                if (receiveLoginMessage.matches("(.*)" + ("Please Try Again Later") + "(.*)")){
                    System.out.print("Please Restart the System Again");
                    System.exit(0);
                }
            }

            String loginMesssage = keyRead.readLine();

            pwrite.println(loginMesssage);
            pwrite.flush();
        }


        while(Server.login.equals(true)){
            while(true)
            {

                //replyinclass = CommandLineInterface.reply;
                //if (flag==1)
                //{
                System.out.print("Input Message sent to core: ");
                sendMessage = keyRead.readLine();  // keyboard reading
                //flag = flag + 1;
                //}
                //else
                ///{
                //replyinclass = CommandLineInterface.reply;
                //sendMessage = replyinclass;
                //}

                if (sendMessage.equals("CloseSystem")) {
                    System.out.print("System is Closed");
                    System.exit(0);
                }

                pwrite.println(sendMessage);       // sending to server
                pwrite.flush();                    // flush the data



                if((receiveMessage = receiveRead.readLine()) != null) //receive from server
                {
                    System.out.print("Message from core: ");
                    System.out.println(receiveMessage); // displaying at DOS prompt
                }

                // start command line interface
                //cli.start(receiveMessage);
                System.out.println("/////////this is the last sentence in main()");


            }

        }
    }

    public static void main(String[] args) throws Exception {
        while(true)
            connectToServer();
    }

}