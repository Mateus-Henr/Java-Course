package tutorial.first;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Moving file
            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            // You need to specify the full path of the destination
            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.move(fileToMove, destination);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
