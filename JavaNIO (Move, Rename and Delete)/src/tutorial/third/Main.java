package tutorial.third;

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
            // Deleting a file
            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.delete(fileToDelete);
            // If you want to avoid the exception in case of non-exiting file
            Files.deleteIfExists(fileToDelete);

            // You can use the delete method to delete directories but they have to be empty.
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
