

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {


    public static void main(String[] arg) throws IOException {
        System.out.println("Client started");
        Socket socket = new Socket("127.0.0.1", 2222);
        System.out.println("Client connected to server");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);
        while (true) {
            String msg = sc.nextLine();
            if(msg.equals("end game")){break;}

        objectOutputStream.writeObject("server:"+msg);
        try {
            String s = (String) objectInputStream.readObject();
            System.out.println(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    }
}
