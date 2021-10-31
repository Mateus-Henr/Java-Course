package tutorial;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    // Walking a file tree
    // Accessing every file and directory that can be reached from a root directory for that tree.
    // It could be used when the application is searching for a specific match in a tree of directories.

    // FileVisitor interface
    // This interface is used to walk a file tree, using its methods you can run code at each stage of the transversal
    // process.
    public static void main(String[] args)
    {
        System.out.println("Walking Tree for Dir2");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");

        try
        {
            Files.walkFileTree(dir2Path, new PrintNames());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
