//package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {


    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        System.out.println("Client started");
        Socket socket=new Socket("127.0.0.1",7777);
        System.out.println("Client connected to server");

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());

        Scanner sc=new Scanner(System.in);
        String s=(String) objectInputStream.readObject();
        System.out.println(s);
        String msg=sc.nextLine();
        objectOutputStream.writeObject(msg);
        System.out.println("next");
        msg=sc.nextLine();
        objectOutputStream.writeObject(msg);
        System.out.println("next");
        msg=sc.nextLine();
        objectOutputStream.writeObject(msg);
        s=(String) objectInputStream.readObject();
        System.out.println(s);


    }
}
