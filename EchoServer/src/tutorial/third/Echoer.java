package tutorial.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Creating a class for the client.
// An instance of this class will be created by each client in a way that will be executed in a separated thread.
public class Echoer extends Thread
{
    private Socket socket;

    public Echoer(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true)
            {
                String echoString = input.readLine();
                System.out.println("Received client input " + echoString);

                if (echoString.equals("exit"))
                {
                    break;
                }

                // This was used to display that one client does not interfere with another. And to demonstrate a
                // timeout.
                // The client is configured to timeout after 5 seconds without communication with the server.
                // Therefore, AS THIS CLASS IS A THREAD EXECUTING THE SERVER, and according to the code below it's
                // "paused" for 15 seconds the client will time out for not being in contact with the server for
                // more than 5 seconds.
                // THE CLIENT AND THE SERVER THREAD FOR THAT SPECIFIC CLIENT TERMINATE.
                try
                {
                    Thread.sleep(15000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Thread interrupted.");
                }

                output.println(echoString);
            }
        }
        catch (IOException e)
        {
            System.out.println("Oops: " + e.getMessage());
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                // Oh, well!
            }
        }
    }

}

// The server doesn't terminate automatically because a client might want to connect even though when there's no clients
// currently connected.