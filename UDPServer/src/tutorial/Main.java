package tutorial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

// In a real word app we would be using Threads.
// UDP is also known as a connectionless protocol since it doesn't perform the end-to-end connection.
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            DatagramSocket socket = new DatagramSocket(5000);

            while (true)
            {
                // This byte array will accept data from the socket.
                byte[] buffer = new byte[50];

                // This "DatagramPacket" will be populated with data received from the socket.
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // This will fill the packet with content. And this method blocks until data is received.
                // Once the data has arrived the buffer passed to the DatagramPacket constructor will contain the data.
                // This method doesn't return anything to send back data to the client, in other words it doesn't
                // create an end-to-end connection as TCP does, since when using TCP after using the "accept()"
                // method a socket was returned that's used to communicate with the client.
                // "Receive" here is an imperative verb.
                socket.receive(packet);

                // We are creating a better String object to remove the null characters. Since we were creating a String
                // based on a buffer, it had unused spaces that were becoming null character.
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));


                String returnString = "echo: " + new String(buffer, 0, packet.getLength());
                byte[] buffer2 = returnString.getBytes();

                // Retrieving the address and the port form the package that was sent to us to send a message back.
                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                // Creating a packet as we did in the client.
                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                socket.send(packet); // Used to send data back to the client.
            }
        }
        catch (SocketException e)
        {
            System.out.println("SocketException: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}
