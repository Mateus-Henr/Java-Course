package tutorial.first;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main
{
    public static void main(String[] args)
    {
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel())
        {
            // All relative writes
            // One unique buffer in which data is being written sequentially. (Cleaner code)

            ByteBuffer buffer = ByteBuffer.allocate(100);

            // Chained put methods
            // As the put method returns the buffer we can chain them as shown below:
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);

            // Normal put sequence
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            buffer.putInt(245);
//            buffer.putInt(-98765);
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes2);
//            buffer.putInt(1000);

            // Calling the flip method after we've written all the values to the buffer.
            buffer.flip();
            // If we remove the flip the buffer position will be set after the last put, therefore there will be nothing
            // to write, consequentially nothing's going to be written to the file.
            binChannel.write(buffer);


            // Reading content from the file
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer); // This method stops reading when it reaches the EOF.
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);

            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());

            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2); // Used to reset the buffer's content with the file's.
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}