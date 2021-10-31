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
            // Creating a file
            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
            Files.createFile(fileToCreate); // Can't be used to create directories
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
