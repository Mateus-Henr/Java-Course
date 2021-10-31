package tutorial.first;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main
{
    public static void main(String[] args)
    {
        // File separator
        // On Windows the backslash ("\") is used to separate a File segment. It varies depending on the OS.
        // It's not a good practise to hard code a separator.
        // Ways of getting the separator based on the OS:

        // Using a constant
        String separator = File.separator;
        System.out.println(separator);

        // Using the getDefault method
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);


        // Example
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter))
        {
            for (Path file : contents)
            {
                System.out.println(file.getFileName());
            }
        }
        catch (IOException | DirectoryIteratorException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
