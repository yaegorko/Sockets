package main;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 5060), 3000);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            for (int i = 0; i < 5000; i++) {
                bufferedWriter.write("Hi" + i);
                bufferedWriter.flush();
                bufferedWriter.newLine();

            }
            bufferedWriter.write("Bue.");
            bufferedWriter.flush();
            for (int i = 0; i < 50000; i++) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
