package tutorial.challenge;

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

            // Getting back to our previous code because we need to store the positions.
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


            // Reading content from the file
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            // MINI CHALLENGE
            // Reading data in reverse order.
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();

            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get((int) (int2Pos + Integer.BYTES), inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt((int) int3Pos));

            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);

            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt((int) int1Pos));
            System.out.println("int2 = " + readBuffer.getInt((int) int2Pos));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}