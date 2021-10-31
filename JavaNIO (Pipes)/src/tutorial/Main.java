package tutorial;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main
{
    // Pipes
    // They're used to transfer data between threads in which data can only flow in one way.
    // They've got two channels:
    // Sync - One or more threads can write to this channel.
    // Source - Other thread or threads can read from this channel.

    public static void main(String[] args)
    {
        // We need two threads one that will read from the source channel and one that will write to the sync channel.
        try
        {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Pipe.SinkChannel sinkChannel = pipe.sink(); // Used to get the sync channel
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++)
                        {
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            // Putting the String into the buffer
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining())
                            {
                                sinkChannel.write(buffer); // Writing the string from the buffer into the sync channel.
                            }

                            buffer.flip(); // For the next iteration of the loop.
                            Thread.sleep(100); // To give the reader a chance
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++)
                        {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];

                            buffer.flip();

                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));

                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}