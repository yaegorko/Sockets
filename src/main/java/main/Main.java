package main;
/*
https://coderanch.com/t/622257/java/Error-java-net-SocketException-Connection
*/
import servers.MyServerSocket;


public class Main {

    public static int i = 0;

    public static void main(String[] args) {
        MyServerSocket serverSocket = new MyServerSocket(5060);
        Thread thread = new Thread(serverSocket);
        System.out.println("Server started");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
