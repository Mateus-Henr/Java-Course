package tutorial.second;

import java.io.IOException;
import java.nio.file.*;

public class Main
{
    public static void main(String[] args)
    {
        // Creating a filter to only display regular files.
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>()
//        {
//
//            @Override
//            public boolean accept(Path path) throws IOException
//            {
//                return Files.isRegularFile(path); // If it returns true the path will be included in the DirectoryStream.
//            }
//        };

        // Equivalent lambda version
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");

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