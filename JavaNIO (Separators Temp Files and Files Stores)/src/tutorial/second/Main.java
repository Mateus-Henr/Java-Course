package tutorial.second;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Creating a temp file (it's created at the default temp directory of the OS)
            // 1° argument - Prefix
            // 2° argument - Suffix
            // OBS: After the prefix there will be an ID that's automatically added by Java.

            // You can create a temp file in another directory by using the other version of this method.
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
