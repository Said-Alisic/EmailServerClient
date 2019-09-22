package Dat18i.Henrik.email.client;

import Dat18i.Henrik.email.threads.ClientThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EmailClient {

    private static final Scanner scn = new Scanner(System.in);

    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) throws IOException {

        System.out.print("Please specify which host to connect to: ");
        String host = scn.nextLine();

        int port = 8080;

        // Only creates new socket when server has accepted the connection
        Socket clientSocket = new Socket(host, port);

        ClientThread clientThread = new ClientThread("ClientThread 1", clientSocket);
        Thread thread = new Thread(clientThread);
        thread.start();

//        // Obtain input and output streams from server to communicate with it
//        // Input stream of server is connected to output stream of client
//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



    }
}
