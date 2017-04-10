package hk.edu.polyu.comp3222.vfs.core;

import hk.edu.polyu.comp3222.vfs.core.command.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class Core {

    private static Socket socket;
    static final int port3000 = 3000;
    public static void main(String[] args) throws Exception {

        System.out.println("Begin of the Program");
        VirtualDisk s = new VirtualDisk();
        //s.read_command();

        ServerSocket sersock = new ServerSocket(port3000);
        System.out.println("Core ready for chatting");
        Socket sock = sersock.accept( );
        // reading from keyboard (keyRead object)
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        // sending to client (pwrite object)
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        // receiving from server ( receiveRead  object)
        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        String receiveMessage, sendMessage = "Please Try Again Later!(init)";

        while(true)
        {
            if((receiveMessage = receiveRead.readLine()) != null)
            {
                System.out.print("Message sent from server: ");
                System.out.println(receiveMessage);
                s.strategy(receiveMessage);
            }
            //   System.out.print("Input Message sent to server: ");
            if (VirtualDisk.command.equals("Create")) {
                sendMessage = Create.reply;
            } else if (VirtualDisk.command.equals("AddFile")) {
                sendMessage = AddFile.reply;
            } else if (VirtualDisk.command.equals("List")) {
                sendMessage = List.reply;
            } else if (VirtualDisk.command.equals("DeleteFile")) {
                sendMessage = DeleteFile.reply;
            } else if (VirtualDisk.command.equals("AddDir")) {
                sendMessage = AddDir.reply;
            } else if (VirtualDisk.command.equals("DeleteDir")) {
                sendMessage = DeleteDir.reply;
            } else if (VirtualDisk.command.equals("DeleteVD")) {
                sendMessage = DeleteVD.reply;
            } else if (VirtualDisk.command.equals("Searching")) {
                sendMessage = Searching.reply;
            } else if (VirtualDisk.command.equals("CheckSize")) {
                sendMessage = CheckSize.reply;
            } else if (VirtualDisk.command.equals("CopyFile")) {
                sendMessage = CopyFile.reply;
            } else if (VirtualDisk.command.equals("RenameFile")) {
                sendMessage = RenameFile.reply;
            } else if (VirtualDisk.command.equals("MoveFile")) {
                sendMessage = MoveFile.reply;
            } else if (VirtualDisk.command.equals("ImportFile")) {
                sendMessage = ImportFile.reply;
            } else if (VirtualDisk.command.equals("ExportFile")) {
                sendMessage = ExportFile.reply;
            } else if (VirtualDisk.command.equals("CopyDir")) {
                sendMessage = CopyDir.reply;
            } else if (VirtualDisk.command.equals("RenameDir")) {
                sendMessage = RenameDir.reply;
            } else if (VirtualDisk.command.equals("MoveDir")) {
                sendMessage = MoveDir.reply;
            } else if (VirtualDisk.command.equals("ImportDir")) {
                sendMessage = ImportDir.reply;
            } else if (VirtualDisk.command.equals("ExportDir")) {
                sendMessage = ExportDir.reply;
            } else if (VirtualDisk.command.equals("CloseSystem")) {
                System.exit(0);
            } else sendMessage = "Invalid Command! Please Try Again";

            pwrite.println(sendMessage);
            //pwrite.println("[done]");

            pwrite.flush();
        }

    }

    /**
     * @return
     * @throws IOException
     */
}