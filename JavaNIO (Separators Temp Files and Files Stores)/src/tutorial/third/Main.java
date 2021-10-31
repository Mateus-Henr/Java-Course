package tutorial.third;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main
{
    public static void main(String[] args)
    {
        // File stores (or drives)
        // For example "C:" on Windows.

        // The "getDefault()" method returns a FileSystem object.
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();

        for (FileStore store : stores)
        {
            System.out.println("Volume name/Drive letter = " + store); // Print the volume name + drive letter name.
            System.out.println("File store = " + store.name()); // Print the volume name.
            // To get just the drive letter, you need to get it out from the string
        }

        // Not ideal way
        System.out.println("\n\nNot ideal way");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();

        for (Path path : rootPaths)
        {
            System.out.println(path);
        }

        // You usually don't need to get the root drives, because there aren't many cases for this.
        // When an application is installed, it remembers or can find out where it lives on the file system.
        // And if it needs the user to tell it where to save or load files it gives the user the option to do so.
    }

}
