//package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket=new ServerSocket(2222);
        while (true) {
    Socket socket = serverSocket.accept();
    System.out.println("A client was connected");
    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
    Object cMsg = objectInputStream.readObject();
    System.out.println("cMsg");
    System.out.println(cMsg);
    if(cMsg.equals("end game")){break;}

   String serverMsg = (String)cMsg;
    for(int i=0;i<serverMsg.length();i++){
        objectOutputStream.writeObject(serverMsg.charAt(i)+":"+(int)serverMsg.charAt(i));
        System.out.println(serverMsg.charAt(i)+":"+(int)serverMsg.charAt(i));
    }

    System.out.println(serverMsg);

}
        }

    }
}
