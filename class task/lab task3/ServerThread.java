package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerThread extends Thread {

    Socket socket;

    ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {



        try {
            System.out.println("A client was connected");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                Object cMsg = objectInputStream.readObject();
                System.out.println("cMsg");
                System.out.println(cMsg);
                if(cMsg.equals("end game")){break;}

                String serverMsg = (String)cMsg;

                System.out.println(serverMsg);
                objectOutputStream.writeObject(serverMsg);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
