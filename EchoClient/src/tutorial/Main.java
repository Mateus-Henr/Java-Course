package tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Differently from the server, in the client we just create a socket, not a server socket.
        // When creating a socket we need to specify the address that we are going to connect to, in this case
        // "localhost" because the server is running on the same host as the client (your computer),
        // and we also need to specify the port number.
        try (Socket socket = new Socket("localhost", 5000))
        {
            // When a client is communicating with a server it doesn't want for it to block forever, for that reason we
            // have timeouts. If the server isn't responding for whatever reason the client needs to report to the user
            // since the user might think that it has frozen or whatever. So if the server doesn't respond within the
            // timeout, a timeout exception is thrown.
            socket.setSoTimeout(5000); // Setting a timeout of 5 seconds. Catching the exception down below.

            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            // Using a do/while loop because we want the code to be executed at least once
            do
            {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine(); // Getting the string from the keyboard.

                // Sending the string to the server.
                stringToEcho.println(echoString);

                if (!echoString.equals("exit"))
                {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));
        }
        catch (SocketTimeoutException e)
        {
            System.out.println("The socket timed out");
        }
        catch (IOException e)
        {
            System.out.println("Client Error: " + e.getMessage());
        }
    }

}
