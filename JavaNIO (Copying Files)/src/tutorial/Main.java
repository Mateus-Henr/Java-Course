package tutorial;

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
            ByteBuffer buffer = ByteBuffer.allocate(100);

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);

            buffer.flip();
            binChannel.write(buffer);


            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());

            readBuffer.flip(); // Switching to write mode
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip(); // Switching to read mode
            System.out.println("int2 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();

            // It's important to set the buffer's current position to the "start byte" position before calling the
            // "transferFrom" method.
            // The position that you pass to the transferFrom method isn't an absolute position, it's a relative
            // position, in other words it's based on the buffer's current position. (Relative position)

            // First argument - Where it should copy from
            // Second argument - The start byte
            // Third argument - The finish byte
            // Calling the method from the destination channel
            // When calling methods that require the channel you need to see if they use an absolute value or relative.
            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            // TransferFrom or TransferTo might be more efficient when you've got the file opened.

            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}