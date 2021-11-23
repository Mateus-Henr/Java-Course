package tutorial;

// UDP (User Datagram Protocol)
// When using it some handshake has to take place between the server and the client, in other words the client has to
// connect to the server and the server has to accept that connection. So the client sends a request and the server
// sends a response, so it's a two-way connection and there's tight coupling between both of them.
// The TCP protocol (used in the Echo project) also performs error checking and will resend massages that don't make it
// to the server (and this overhead, like sending messages back, ect do affect performance).
// When using UDP there's no handshaking at all and the destination host (which may or may not be a server) doesn't
// actually send any responses to the message sender, so it's used when you don't need a two-way connection or when
// speed is essential. Therefore, if you want a response of a message sent over the network you wouldn't use UDP.
// UDP uses datagrams which are self-contained messages that are not guaranteed to arrive at its destination.
// It's used for time-sensitive communication and when losing the message or packet here or there won't matter.
// For example application like Skype, they usually use UDP since speed is more important that ensuring that every
// packet arrives.
// Also, the data arriving to the client is immediately replaced by more data, so it's not critical that all the
// messages hit the client.

// UPD and TCP are low-level API, so we don't have to take care of the complicated stuff.

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Getting the address of the host, "localhost" because the server will be run on this machine.
            // If running the server on a different machine you would use "getByName()".
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket(); // The socket isn't associated to a port number.

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do
            {
                System.out.println("Enter the string to be echoed: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                // A datagram is a self-contained message, it's like a package, it receives everything it needs and
                // packages it, as you can see below:
                // When using TCP, the server only needed the info to communicate with the client, it didn't need the
                // info of each message.
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet); // Sending the "package" to the server, like Amazon.


                // Receiving a response
                // KEEP IN MIND that when using UDP you usually don't want a response, this is only been setting here
                // now for demonstration purposes.
                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length); // Allocating a packet for receiving data.
                datagramSocket.receive(packet); // This will block until it receives data from the server.
                System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));


            } while (!echoString.equals("exit"));
        }
        catch (SocketTimeoutException e)
        {
            System.out.println("The socket timed out.");
        }
        catch (IOException e)
        {
            System.out.println("Client error: " + e.getMessage());
        }
    }

}
