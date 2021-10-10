

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket=new ServerSocket(2222);
while (true) {
    Socket socket = serverSocket.accept();
//    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

//    Object cMsg = objectInputStream.readObject();
//    System.out.println("cMsg");
//    System.out.println(cMsg);
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    System.out.println(formatter.format(date));

//   String serverMsg = (String)cMsg;
    System.out.println("A click is connected");
    objectOutputStream.writeObject(formatter.format(date));
}

    }
}
