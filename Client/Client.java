package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import relation.Relation;
 
public class Client { 
    //evoie et ecriture
    static final String serverName = "localhost";
    static final int serverPort = 9999;
     public static void main(String[] args) throws Exception, IOException {
        Socket socket = new Socket(serverName, serverPort);
        System.out.println("Socket client: " + socket );
        Scanner scann = new Scanner(System.in);
        PrintWriter output = new PrintWriter(socket.getOutputStream());
    
        while (true) {
            // System.out.println("Ecrivez une requette");
            // String message;
            // message=scann.nextLine();
            // output.flush();
            // output.println(message);
            
            // ObjectInputStream imput = new ObjectInputStream(socket.getInputStream());
            // Relation relation = (Relation)imput.readObject(); 
            // System.out.println(relation.getColonne()[0]);
            
            String message = scann.nextLine();
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(message);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Relation messParServer =(Relation) inputStream.readObject();  
            System.out.println(messParServer);

        }
      // socket.close();

    }
}