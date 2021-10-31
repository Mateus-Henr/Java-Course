package tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main
{
    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(5000))
        {
            // This method will block until a client connects to the server
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected.");

            BufferedReader input = BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
