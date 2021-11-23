package tutorial.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// SERVERS THAT CAN CONNECT WITH MULTIPLE CLIENTS WILL RUN MULTIPLE THREADS.
public class Main
{
    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(5000))
        {
            // As we will have multiple clients a class was created for constructing them.
            while (true)
            {
                // Creating a thread for each client connected to the server in order to for one not to block
                // the other. So, everytime we accept a connection we are running a thread for the client.
                // By doing it even if one client takes a while to "respond" it won't interfere other threads.
                new Echoer(serverSocket.accept()).start();

                // The code above could also be written as:
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
            }
        }
        catch (IOException e)
        {
            System.out.println("Server exception " + e.getMessage());
        }
    }

}
