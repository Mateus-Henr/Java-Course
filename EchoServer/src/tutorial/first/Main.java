package tutorial.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// This will just echo back to the client a message.
public class Main
{
    public static void main(String[] args)
    {
        // The server port can be a number between 0 and 65535, which some of them are already reserved.
        // To detect if you can use a specific port number you can just assign it to a socket and see if the socket
        // instance was successfully created.
        // Here we are creating the "server" that is going to be used for connection.
        try (ServerSocket serverSocket = new ServerSocket(5000))
        {
            // Every client that are going to connect with the server will use the same port, but through its own
            // socket.
            // This method will block until a client connects to the server, so if we try to run the app without a
            // client waiting or about to connect the app will just keep executing.
            Socket socket = serverSocket.accept(); // This will be the socket used to communicate with the client.
            System.out.println("Client Connected.");

            // A common practise is to wrap things as below.
            // The "BufferedReader" is used to get the messages that the client sent through the socket and the
            // "PrintWriter" is used to send the message to the client.
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // The second parameter is used to automate the sending of the data, otherwise you have to call the
            // "flush()" method everytime.
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true)
            {
                String echoString = input.readLine(); // Getting the message

                if (echoString.equals("exit"))
                {
                    break;
                }

                // Writing the message back in the socket (echoing it back to the client)
                output.println("Echo from server: " + echoString);
            }

        }
        catch (IOException e)
        {
            System.out.println("Server exception " + e.getMessage());
        }
    }

}
