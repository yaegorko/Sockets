package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocket extends Thread {

    ServerSocket serverSocket;
    Socket socket;
    int i = 1;


    public MySocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        try {
            this.socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try
           {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String s;
            while (!(s = reader.readLine()).equals("Bue.")) {
                writer.write(s);
                writer.flush();
                i++;
            }

        } catch (IOException e) {
            System.out.println("Сокет отработал " + i);
            System.out.println("И еще ошибка");
            e.printStackTrace();
        }
//        try {
//            socket.close();
//        } catch (IOException e) {
//            System.out.println("ошибка при закрытии");
//        }
    }
}
