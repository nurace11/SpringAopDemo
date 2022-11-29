package com.example.aopdemo;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketExample {
    public static void main(String[] args) throws Exception{
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("127.0.0.1", 4001), 2500);
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
