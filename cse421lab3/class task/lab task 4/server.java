//package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server{

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(7777);
        System.out.println("server started");
while (true) {
    Socket socket = serverSocket.accept();
    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

    objectOutputStream.writeObject("For addition press 1\nFor subtraction press 2\nFor multiply. press 3");

    System.out.println("client connected");
    String cMsg;
    try {
    cMsg = (String)objectInputStream.readObject();
    int op=Integer.parseInt(cMsg);
        System.out.println(op);
     cMsg = (String)objectInputStream.readObject();
    int value1=Integer.parseInt(cMsg);
        System.out.println(value1);
    cMsg = (String)objectInputStream.readObject();
    int value2=Integer.parseInt(cMsg);
        System.out.println(value2);
    int result;
    System.out.println("got all the value");
    if (op==1){
        result= value1+value2;
    }else if (op==2){
        result= value1-value2;
    }else if (op==3){
        result= value1*value2;
    }else{
        objectOutputStream.writeObject("wrong input enter value again");
        continue;
    }
    cMsg=""+result;
        objectOutputStream.writeObject(cMsg);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }




}

    }
}
