package Dat18i.Henrik.email.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private String name;
    private String host;
    private int port;
    private Socket clientSocket;

    public ServerThread(String name, String host, int port, Socket clientSocket) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        System.out.println( Thread.currentThread().getName()+ " is running!");
        try {
            // Obtain input and output streams to communicate with client
            // Input stream of client is connected to output stream of server
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (!clientSocket.isClosed()) {
                System.out.println("Running..." + clientSocket.getRemoteSocketAddress());



                // Prints to client
                String clientInput;
                while((clientInput = in.readLine()) != null) {
                    // Echo client message back to client side
//                    out.println("EmailServer- Client input: " + clientInput);
                    out.println("EmailServer: Hello client, this is an automated message.");
                    System.out.println(clientInput);
                }
                // Prints to server
//                System.out.println(in.readLine());

                if(in.readLine().equalsIgnoreCase("Disconnect")) {
                    clientSocket.close();
                    System.out.println("Disconnected!");
                }

            }
        } catch (IOException ioe) {
            System.err.println("Could not accept client connection at host: " + host + " - port: " + port);
        }
        System.out.println("Terminating connection...");

    }
}
