package com.example.aopdemo;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HttpConnection {
    public static void main(String[] args) throws Exception {
        connection("http://google.com");

        try{
            connection("http://localhost:3000");
        } catch (Exception e) {}

        connection("http://localhost:8080/api/clients");
    }


    public static void connection(String URL) throws Exception{
        URLConnection urlConnection = new URL(URL).openConnection();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
//        scanner.useDelimiter("\\Z");
//        System.out.println(scanner.nextLine());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        System.out.println();
    }
}
