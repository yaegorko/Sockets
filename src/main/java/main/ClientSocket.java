package main;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) {
        String s;
        try(Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("127.0.0.1", 5060), 3000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            for (int i = 0; i < 5000; i++) {
                bufferedWriter.write("Hi" + i);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Bue.");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            while (true) {
                s = reader.readLine();
                System.out.println(s);
                 if (s.equals("Bue.")) {
                     socket.close();
                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
