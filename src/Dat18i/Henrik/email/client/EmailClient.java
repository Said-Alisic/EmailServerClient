package Dat18i.Henrik.email.client;

import Dat18i.Henrik.email.threads.ClientThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailClient {

    private static final Scanner scn = new Scanner(System.in);

//    private static PrintWriter out;
//    private static BufferedReader in;

    // Thread Pool to reuse and create new threads as required
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {

        System.out.print("Please specify which host to connect to (127.0.0.1 as default): ");
        String host = scn.nextLine();

        int port = 8080;

        // Only creates new socket when server has accepted the connection
        Socket clientSocket = new Socket(host, port);

        ClientThread clientThread = new ClientThread("ClientThread 1", clientSocket);
//        Thread thread = new Thread(clientThread);
//        thread.start();

        threadPool.execute(clientThread);

//        // Obtain input and output streams from server to communicate with it
//        // Input stream of server is connected to output stream of client
//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



    }
}
