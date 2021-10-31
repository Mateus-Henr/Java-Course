package tutorial.first;

//  Channel
//  A channel is the data source you're reading from or writing to.
//   It can be a file, a socket or any other data source.
//   To use a data source as a channel you need a class that implements
//   the "java.nio.channel" interface and that can connect to the data source.
//   The JDK contains channels for several data sources, including file, network IO
//   as well as sockets.
//
//
//   Buffer
//   A buffer is a container for the block of data that you want to read or write.
//   Buffers are typed, which means that they can only hold one type of data and you
//   can also specify its size.
//
//   Selectors
//   Selectors allow a single thread to manage the IO for multiple channels.
//   They are used in large enterprise applications.
//
//   Streams
//   Can be byte based or character based.
//   When using it you need two instances of a java.io class if you want to both
//   read and write a file (one instance for each).
//   But when working with NIO only one instance is necessary and these operations
//   are always buffered.

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

// Generally you should go for java.nio when working in a large application that uses multiple threads to do IO.
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Old way
//            FileInputStream file = new FileInputStream("data.txt");
            // Creating a channel
            // Because this channel only opens for reading,
            // it's an exception to the rest of channels that do both operations.
//            FileChannel channel = file.getChannel();

            // When you create a buffer to work with a channel you have to specify the size of the buffer,
            // which will specify how many bytes are read from the file at any one time.
            // On each read you'll have to pass the buffer for new lines.
            // getDefault() is used to get the current working directory in IntelliJ's case it's the "idea" directory.
            Path dataPath = FileSystems.getDefault().getPath("data.txt");

            // When using Files class each write is considered an isolated write in the sense that you don't
            // open a file call the write method an then close the file. Meaning that each call to the write method
            // consists of the entire process.
            // Therefore for writing more than one line is recommended to use StringBuilder for example to build the
            // text and then just write one thing.
            // The file write method writes bytes not strings, so the string.getBytes method will be used to convert
            // a string to bytes.
            // The "StandardOpenOption.APPEND" is used to write in a file that already exists, appending the new text.
            // Without this parameter the file is overwritten.
            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
            // This reads the entire file into memory.
            List<String> lines = Files.readAllLines(dataPath); // UTF-8 is used as default here.
            for (String line : lines)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
