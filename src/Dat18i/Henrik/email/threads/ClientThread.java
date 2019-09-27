package Dat18i.Henrik.email.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {

    private String name;
    private Socket clientSocket;

    public ClientThread(String name, Socket clientSocket) {
        this.name = name;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        System.out.println(Thread.currentThread().getName() + " is running!");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));


            while (!clientSocket.isClosed()) {

                System.out.println("Running..." + clientSocket.getPort());

                String userInput;
                while ((userInput = stdIn.readLine()) != null) {
                    out.println(userInput);
                    System.out.println(in.readLine());
                }

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Could not establish connection to server!");
        }
        System.out.println("Terminating...");

    }
}
