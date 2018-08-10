package main;
/*
https://coderanch.com/t/622257/java/Error-java-net-SocketException-Connection
*/

import servers.MyServerSocket;
import sockets.MySocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static int i = 0;
    private static ExecutorService service = Executors.newFixedThreadPool(5);
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) {
        System.out.println("Server started");
        withThreadPool();
    }

    static void withThreadPool() {
        try {
            serverSocket = new ServerSocket(5060);
            while (true) {
                socket = serverSocket.accept();
                service.submit(new MySocket(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void withoutThreadPool() {
        MyServerSocket serverSocket = new MyServerSocket(5060);
        Thread thread = new Thread(serverSocket);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
