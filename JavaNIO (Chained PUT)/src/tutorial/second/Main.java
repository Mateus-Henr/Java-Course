package tutorial.second;

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
            // We've been using RandomAccessFile because it's convenient to get a channel from it.
            // Do you remember that RandomAccessFile is used if you want to navigate throughout the file?
            // As we are writing data sequentially we could use input stream.
            FileChannel channel = ra.getChannel();

            // If you want to jump around in a file you have to use a seekable byte channel, which has the notion of a
            // current position. This is actually an interface that has:

//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

            // Reading data in reverse order.
            // This was also a MINI CHALLENGE, my version of it can be found at the "challenge" package.
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

            // If you were to lead data on demand based on the length of the index is best to create a buffer depending
            // on the side of the data, instead of creating a buffer that can be used for all of different data.

            byte[] outputString = "Hello World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;

            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputBytes)); // Takes care of flipping
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputBytes2));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}