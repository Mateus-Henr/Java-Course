package tutorial.first;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n\nOutThere");
        printFile(Paths.get("F:", "JavaCourse", "OutThere.txt"));

        System.out.println("\n\nthisfiledoesntexist");

        // Until you actually try to access a file the path is actually abstract.
        // So it doesn't matter if the path doesn't exist.
        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
        System.out.println(path3.toAbsolutePath());

        // To create a file the directory specified must exist.
        Path path4 = Paths.get("z:\\s\\dsds", "whatever.txt");
        System.out.println(path4.toAbsolutePath());

        // Checking if the file directory exists
        Path filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exists = " + Files.exists(filePath));

        // It has a second argument to handle symbolic links
        System.out.println("Exists = " + Files.exists(path4));

        // You can check if your app has permissions to access a file by using isReadable, isWritable or isExecutable
        // method.
    }

    private static void printFile(Path path)
    {
        try (BufferedReader fileReader = Files.newBufferedReader(path))
        {
            String line;

            while ((line = fileReader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}