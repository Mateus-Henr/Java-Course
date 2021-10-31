package tutorial.second;

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
             FileChannel binChannel = binFile.getChannel()) // Will be closed because of the try-with-resources.
        {
            byte[] outputBytes = "Hello World!".getBytes();

            // It's important to remember that modifications in the array or buffer will modify both array + buffer.
            // When using the method below we are telling the runtime that we want to use the byte array as the buffer.

            // First it wraps the byte array into the buffer
            // When using the wrap method you're telling the runtime that you want to use the byte array as the buffer.
            // Also it sets the buffer's position to zero automatically (differently from the "write" method)
            // and the byte's array length will be the buffer's capacity.
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes); // Creating a byte buffer from the array
            int numBytes = binChannel.write(buffer); // Using the channel to write to a file.
            System.out.println("numBytes written was: " + numBytes);

            // Generally it's better to create a new buffer rather than changing type of a previous one.
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES); // Passing the size we want the buffer to be.
            intBuffer.putInt(245);
            intBuffer.flip(); // Resetting the position to 0. Needs to be done manually to prevent multiple writes.
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);
            // Doing it this way (without the "reset"), it won't write the Integer nor calculate the size of it.
            // When we created the buffer the position of the buffer was set to zero, and when we call the putInt
            // method we wrote the int into the buffer which changed it's position.
            // And the write method starts reading at the buffer's position (therefore after the int).
            // When writing ints you can know where the next position will be like (4, 8, 12) since four is the number
            // of bytes for an integer.


            // If we don't use the flip method (below):
            // After it writing the previous number to the file, the buffer's position was set to 4, but the buffer's
            // only 4 bytes long (size of an Integer) as we've declared before, hence an exception will sprout.
            // So the flip method solves the problem since it resets the buffer's position to 0.

            // You don't need to use it all the time but when you change to read to write or the opposite you need to do
            // it. It's required once you're reading from the buffer and writing to the channel.
            intBuffer.flip(); // Always call it whenever you want to reset a buffer's position to zero.
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            // Reading file using IO package
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            byte[] b = new byte[outputBytes.length];
            ra.read(b);
            System.out.println(new String(b));

            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

// A buffer's capacity is the number of elements it can contain.
// A buffer's position is the index of the next element that should be read or written (it can't be greater than the
// buffer's capacity)
// A buffer's mark is used by the buffer.reset method and when it's called the buffer's position is reset to its mark.
// If you want to rewind the buffer to a certain point, you'll mark the point, then later you'll call the reset method
// to reset the position to the mark.
// When you've filled a buffer and you're ready to write it to a channel, you'll be reading from the buffer at
// THAT POINT (so flip is required).