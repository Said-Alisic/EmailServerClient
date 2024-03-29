package Dat18i.Henrik.email.server;

import Dat18i.Henrik.email.threads.ServerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailServer {

    private static final String HOST = "127.0.0.1";
//    private static final String HOST = "10.111.168.86";
    private static final int PORT = 8080;

    // Thread Pool to reuse and create new threads as required
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {


        // Server runs on a specific computer with a socket bound to a specific port
        ServerSocket serverSocket = new ServerSocket(PORT);

        // Server listens to the socket to check if a client has made a connection request
        Socket clientSocket = serverSocket.accept();

        ServerThread serverThread = new ServerThread("ServerThread 1", HOST, PORT, clientSocket);
//        Thread thread = new Thread(serverThread);
//        thread.start();

        threadPool.execute(serverThread);

//        // Obtain input and output streams to communicate with client
//        // Input stream of client is connected to output stream of server
//        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));





    }


}
