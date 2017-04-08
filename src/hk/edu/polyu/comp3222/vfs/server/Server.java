package hk.edu.polyu.comp3222.vfs.server;

import java.io.*;
import java.net.*;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.sql.*;
class Server {
    public static void main(String argv[]) throws Exception { String clientSentence,clientpassword;
    String capitalizedSentence;
    ServerSocket welcomeSocket = new ServerSocket(4003);
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/";
    String db = "database";
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String pass = "root";
    while(true) { Socket connectionSocket = welcomeSocket.accept();
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        BufferedReader inFromClient1 = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        clientSentence = inFromClient.readLine();
        clientpassword = inFromClient.readLine();
        System.out.println("Received User Name: " + clientSentence);
        System.out.println("Received Password: " + clientpassword); Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url+db, user, pass);
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM table WHERE user='clientSentence' AND password='clientpassword'");
        while (res.next()) { String u = res.getString("user");
            String p = res.getString("password");
            if (clientSentence.equals(u) && clientpassword.equals(p)){ capitalizedSentence = "Welcome "+clientSentence+" \n";
                outToClient.writeBytes(capitalizedSentence);
            }else{ capitalizedSentence = "Sorry, not authorized \n"; outToClient.writeBytes(capitalizedSentence);
            }con.close(); } } } }
