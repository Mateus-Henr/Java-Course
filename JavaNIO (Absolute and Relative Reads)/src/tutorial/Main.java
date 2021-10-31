package tutorial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main
{
    // Writing Binary Files
    public static void main(String[] args)
    {
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel())
        {
            byte[] outputBytes = "Hello World!".getBytes();

            // Instead of using the "wrap" method and passing the byte array, we are allocating a buffer and putting
            // the content into the buffer.
            // It's different from the "wrap" method because when using wrap the byte array backs the buffer, they are
            // kinda "the same object". In the current code a new byte array is created, therefore we've got two
            // separated objects.
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);

            // MINI CHALLENGE SOLUTION
            buffer.flip();
            // Based on the new added code above, it's going to throw an exception without the code of the challenge
            // found above. Because when we use the put method we write to the buffer and when we use the "write"
            // method we read from the buffer.

            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            // The so-called MANTRA to fixing problem with NIO....
            // WHEN SOMETHING GOES WRONG FLIP. AND THAT'S ALL.

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            // Reading file using NIO package
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            // Changing the buffer in memory
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            // Without this flip method we won't be able to read data back into the buffer, since it'll be at the end
            // of the buffer.
            buffer.flip();
            long numbBytesRead = channel.read(buffer); // Reading back into the byte buffer. Therefore alters the buffer as well.
            // This way we are recreating "Hello World" and fixing the buffer that had "a" and "b" within it.

//            System.out.println("outputBytes = " + new String(outputBytes));

            if (buffer.hasArray()) // Good Practise
            {
                // When using the wrap method we didn't have to call the array method because the outputBytes array was
                // backing the buffer.

                // outputBytes array is different from the one that we get from the buffer.
                System.out.println("Byte buffer = " + new String(buffer.array()));
//                System.out.println("Byte buffer = " + new String(outputBytes));
            }
            // Relative Read - When we pass no parameters (buffer's current position)
            // Absolute Read - When we pass a parameter to the buffer (chosen position)

//
//            // RELATIVE READ
//            // Reading and writing in the buffer.
//            intBuffer.flip();
//            numbBytesRead = channel.read(intBuffer); // This method writes the buffer
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt()); // This method reads the buffer
//            intBuffer.flip();
//            numbBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//
//            System.out.println(intBuffer.getInt());
//            channel.close(); // Closing here because we didn't create the objects with try-with-resources.
//            ra.close();

            // ABSOLUTE READ
            // Avoiding "flip()" when reading data
            // If you call the getInt method without any parameters the reading will start at the buffer's current
            // position, however you can pass an index to get int for the method to start from.
            intBuffer.flip();
            numbBytesRead = channel.read(intBuffer);
            System.out.println(buffer.getInt(0));
            intBuffer.flip(); // Needs to be used to write the buffer
            numbBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            // The AR doesn't change the buffer's position, if that were true we wouldn't get an exception when trying to
            // call an relative read without the flip method.
            System.out.println(intBuffer.getInt(0)); // Buffer position isn't updated. ABSOLUTE READ (AR)
            System.out.println(intBuffer.getInt()); // RELATIVE READ


            // For the reasons above it's best to choose between one or the other.
            channel.close();
            ra.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}