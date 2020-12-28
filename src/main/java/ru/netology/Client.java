package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            sendMessage(out, in, scanner); //name
            sendMessage(out, in, scanner); //age
            System.out.println(in.readLine()); //greeting
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sendMessage(PrintWriter out, BufferedReader in, Scanner scanner) throws IOException {
        System.out.print(in.readLine());
        out.println(scanner.nextLine());
    }
}
