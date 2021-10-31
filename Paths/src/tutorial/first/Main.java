package tutorial.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//  Path (Interface)
//  It's used to identify a file on the file system ("path of a file (C:\)").
//  Delimiter on Windows is "\", on Unix is "/".
//
//  Absolute Path
//  C:\Downloads\file.txt" is an absolute path, because it starts at a root node.
//
//  Relative Path
//  "Photos\vacation\mountain.jpg" is a relative path because it doesn't specify a root node,
//  it doesn't contain enough information to identify the file. It would have to be combined with another path that
//  does contain a root node.
//
//  Paths in applications
//  When using relative paths in apps, there's usually the concept of a current or working directory that you can combine with relative paths.
//  Ex:
//  When using Path:
//      Path dataPath = FileSystem.getDefault().getPath("data.txt");
//  What's happening is that the getDefault() call returns a FileSystem object with a working directory set to the current user directory.
//  With an IDE it's usually the project directory the "working directory".
//  Could also be used (absolute path):
//      Path dataPath = Paths.get("C:\\MyIdeaProjects\\Project1\\data.txt")
//  But here the Path("s") and the method returns a Path based on a String.

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("WorkingDirectoryFile");
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        System.out.println("\n\nSubDirectoryFile");
        printFile(FileSystems.getDefault().getPath("files", "SubDirectoryFile.txt"));

        System.out.println("\n\nOutThere");
        // We need to use path because we can't use "getDefault()" here.
//        printFile(Paths.get("..\\OutThere.txt"));
//        printFile(Paths.get("F:\\JavaCourse\\OutThere.txt"));
        printFile(Paths.get("F:", "JavaCourse", "OutThere.txt"));
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
