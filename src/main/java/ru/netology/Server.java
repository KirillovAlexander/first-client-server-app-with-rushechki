package ru.netology;

import ru.netology.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            System.out.println("New connection accepted");
            String name = getMessage(out, in, "Enter your name: ");
            int age = Integer.parseInt(getMessage(out, in, "Enter your age: "));
            User user = new User(name, age);
            sendGreetings(out, user);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String getMessage(PrintWriter out, BufferedReader in, String messageToClient) throws IOException {
        out.println(messageToClient);
        return in.readLine();
    }

    private static void sendGreetings(PrintWriter out, User user) {
        if (user.isAdult())
            out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", user.getName()));
        else out.println(String.format("Welcome to the kids area, %s! Let's play!", user.getName()));
    }
}
