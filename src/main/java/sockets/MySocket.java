package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocket extends Thread {

    ServerSocket serverSocket;
    Socket socket;
    int i = 0;

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
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String s;
            while (true) {
                s = reader.readLine();
                writer.write(s);
                writer.newLine();
                writer.flush();
                i++;
                if (s.equals("Bue.")) {
                    System.out.println(s);
                    socket.close();
                    break;
                }
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Сокет отработал " + i + " раз и сломался");
            e.printStackTrace();
        }
    }
}
