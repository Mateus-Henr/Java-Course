package tutorial;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {
        // File (IO) vs Path (NIO)
        // You can use "toPath" method to convert and old style file instance to the preferred java.nio.path instance.
        // Just like with paths it doesn't matter if the string points to an existing file.
        // With streams if the path doesn't exist it'll be created.
        File file = new File("C:\\Examples\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        // The version of the "resolve" (NIO method) in IO.
        // 1° argument - The parent (where it's going to be copied at). Can be a String or a File object.
        // 2° argument - The child (of the path that we are going to copy).
        File parent = new File("C:\\Examples");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("C:\\Examples", "dir\\file.txt");
        System.out.println(resolvedFile.toPath());


        // Equivalent result from the result above, but now using NIO
        Path parentPath = Paths.get("C:\\Examples");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));


        // For move, delete and rename from NIO there are the equivalent methods in IO.

        // Differently from using "getDefault()" that returns a path (when using NIO), for IO we need to use a File
        // instance (there are drawbacks when doing it).
        File workingDirectory = new File("").getAbsoluteFile(); // Most robust way to do this.
        // When we pass a empty string to the File constructor, it translates to the current directory.
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());


        // In Java NIO we were using streams, but in Java IO we use list (returns an array of strings) method and
        // listFiles (returns an array of files), also can be passed a filter to the list method.
        System.out.println("Print Dir2 contents using list()");
        File dir2File = new File(workingDirectory, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for (int i = 0; i < dir2Contents.length; i++)
        {
            System.out.println("i = " + i + ": " + dir2Contents[i]);
        }
        // It only shows one level deep.

        // Equivalent version of the method above.
        System.out.println("Print Dir2 contents using listFiles()");
        File[] dir2Files = dir2File.listFiles();
        for (int i = 0; i < dir2Files.length; i++)
        {
            // The "getName" method returns the last segment to the file path, that's the file name.
            System.out.println("i = " + i + ": " + dir2Files[i].getName());
        }

        // Getting a system's root drives or file stores
        // As said before it's problematic, because it lists drive letters for drives that aren't available.
        // You can use "File.listRoots()" method to get the roots, but it'll have the same problems as the
        // "FileSystem.getRootDirectories()" method, described above.

        // In general IO and NIO have straightforward differences that can be noticed through the methods names.

        // ALWAYS WORK WITH JAVA.NIO WHEN WORKING WITH THE FILE SYSTEM, BUT WHEN IT COMES TO READING AND WRITING
        // FILE CONTENTS SOMETIMES JAVA.IO IS THE BETTER CHOICE.
    }

}
