package com.example.aopdemo;

import java.io.PrintWriter;
import java.net.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ServerSocketExample {
    public static void main(String[] args) throws Exception {
        System.out.println("Server started...");
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(4001);
                 Socket socket = serverSocket.accept()) {
                System.out.println("Connection from " + socket.getRemoteSocketAddress());

                Scanner scannerIn = new Scanner(socket.getInputStream());
                PrintWriter writerOut = new PrintWriter(socket.getOutputStream(), true);

                writerOut.println("hello on the server " + socket.getLocalAddress());
                writerOut.println("Time: " + LocalDateTime.now());
            }
        }

    }
}
