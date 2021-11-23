package tutorial.second;

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
            // Moving everything into the while loop to possibility multiple client connections to the server. So,
            // everytime a client connects to the server it'll have its own input and output stream for communication.
            while (true)
            {
                // The first problem when using multiple clients is that after sending a message, the server will
                // block here in the "accept()" method, because it'll wait for another client to connect.
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected.");

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // With multiple clients, by running one and not inputting anything into it, it'll wait for the user
                // input, so the line below will wait to be executed. Because of that, the server won't be able
                // to accept the other socket, since it needs to call the "ServerSocket.accept()" method to do so.
                String echoString = input.readLine();

                try
                {
                    Thread.sleep(1500);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Thread interrupted.");
                }

                if (echoString.equals("exit"))
                {
                    break;
                }

                output.println("Echo from server: " + echoString);
            }

        }
        catch (IOException e)
        {
            System.out.println("Server exception " + e.getMessage());
        }
    }

}
