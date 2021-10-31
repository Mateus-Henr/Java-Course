package tutorial.second;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Copying a file
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
            // This third parameter is used to tell the method that we want to create the file even if it already exists.
            // It can be used when you app uses the concept of saving a file, like Intellij (because the temporary
            // file is replaced by the permanent file)
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            // Copying a directory
            // OBS: It doesn't copy the content of the directory.
            // If you want to copy the directory + its content you need to walk the file tree.
            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e)
        {
            // If the file already exists and if we aren't using the third parameter, we will get an exception.
            System.out.println(e.getMessage());
        }
    }

}