package tutorial.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("WorkingDirectoryFile");
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        System.out.println("\n\nSubDirectoryFile");
        path = Paths.get(".", "files", "SubDirectoryFile.txt");
        printFile(path);

        System.out.println("\n\nOutThere");
        printFile(Paths.get("F:", "JavaCourse", "OutThere.txt"));

        System.out.println("\n\nDot Path");
        path = Paths.get("."); // "." is used to refer to the current directory, similarly to terminal.
        System.out.println(path.toAbsolutePath());

        // Example
        // D:\Examples\.\subfolder\..\directory
        // The path above is a valid path, however using "." is redundant.
        // The ".." refer to the parent directory (move up).
        // It can be read as:
        // D:\Examples\directory

        // To remove unnecessary parts in a path
        // It's useful when you're getting the path from the user or another source.
        System.out.println("\n\nFixed Path");
        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubDirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());
    }
    // We could have used "Paths" to the first two files as well. But when you know the files path will be relative to
    // your working directory, it's a better practise to use the way shown.
    // You can't guarantee where the user is going to install your application at, therefore if you want to download
    // stuff within your app or with your app , you can't use an absolute path.

    // You could have the installer store the install path somewhere, but is better to use methods.
    // However for user created files, absolute path is better.

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

// The java.io.File class also points to the file on the file system, but it has some problems, that's why we use
// the "Path" interface, the problems are:
// - Many methods in the class don't throw exception, or don't provide specific error messages when they fail.
// - The "File.rename()" method works differently on different platforms. (and Java is supposed to be multiplatform)
// - No support for symbolic links (that is a kind of file that points to another file). They're often used with
//   networks, to point to a remote location. The File class doesn't understand them.
// - Doesn't provide a way to get metadata about a file, such as its permissions, its owner, and other security
//   information.
// - Many of the methods don't perform well when working with lots of data.
// - Since the File class doesn't understand symbolic links, walking a directory tree is problematic.