package tutorial.second;

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
            // Renaming a file
            Path fileToRename = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path newName = FileSystems.getDefault().getPath("Examples", "file2.txt");
            // The same method for moving a file is used to rename a file, you could say that we are "moving" it
            // to a new name.
            // So when renaming a file the source and destination path must be the same, otherwise the file
            // will be moved or moved + renamed.
            Files.move(fileToRename, newName);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
