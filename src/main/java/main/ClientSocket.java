package main;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 5060), 100000);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(socket.getInputStream());
            for (int i = 0; i < 5000; i++) {
                bufferedWriter.write("Hi" + (Integer) i);
                bufferedWriter.flush();
                bufferedWriter.newLine();

            }
            bufferedWriter.write("Bue.");
        } catch (IOException e) {

        }
    }
}
