package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while (true) {
            ServerSocket serverSocket=new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            new ServerThread(socket).start();
            //socket.close();


        }

    }
}
