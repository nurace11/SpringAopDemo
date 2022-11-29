package com.example.aopdemo;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HttpConnection {
    public static void main(String[] args) throws Exception {
        URLConnection google = getConnection("http://google.com");
        printHeaders(google);

        try {
            printHeaders(getConnection("http://localhost:8080/api/clients"));
        } catch (Exception e) {}

/*        connection("http://google.com");

        try{
            connection("http://localhost:3000");
        } catch (Exception e) {}

        connection("http://localhost:8080/api/clients");*/
    }

    public static URLConnection getConnection(String url) throws Exception {
        return new URL(url).openConnection();
    }

    public static void printContent(URLConnection connection) throws IOException {
        Scanner scanner = new Scanner(connection.getInputStream());

        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        System.out.println();
    }

    public static void printHeaders(URLConnection connection) throws Exception{
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        System.out.println();
    }

    @Deprecated
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
