package servers;

import main.Main;
import sockets.MySocket;

import java.io.IOException;
import java.net.ServerSocket;

public class MyServerSocket implements Runnable {

    private final int port;

    public MyServerSocket(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println(Main.i++);
        try(ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                MySocket mySocket = new MySocket(serverSocket);
                mySocket.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
