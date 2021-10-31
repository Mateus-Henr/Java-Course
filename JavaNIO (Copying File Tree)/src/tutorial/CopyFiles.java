package tutorial;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path>
{
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot)
    {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
    {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        // The method below is being used to figure out the path for the copied file.
        // This method constructs a relative path that resolves to the given path. ("What we are going to copy")
        // MORE ABOUT IT AT THE END OF THIS FILE

        // Example that we are going to do:
        // File that we are going to copy "FileTree\Dir2\Dir3\file1.txt".
        // Destination of the copy "FileTree\Dir4" (it's going to be a subfolder called "Dir2Copy" that will contain
        // "\Dir3\file1.txt").
        // The root of the source path is "FileTree\Dir2".
        // The root of the destination path is "FileTree\Dir4".
        Path relativizedPath = sourceRoot.relativize(dir); // Getting the relativized path for the source root.
        System.out.println("RelativizedPath = " + relativizedPath);
        // EXAMPLE AT THE END OF THIS FILE

        // This method will transform the path from the relatized method into the full path for the copied files.
        Path copyDir = targetRoot.resolve(relativizedPath); // Getting the path for the copy.
        System.out.println("Resolved path for copy = " + copyDir);

        try
        {
            Files.copy(dir, copyDir); // Making the copy
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            // If an exception happens we skip the current directory (stop processing entries for that directory).
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("RelativizedPath = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);

        try
        {
            // You could pass more parameters to the copy method to tell the program what should happen if the
            // directory already exists.
            Files.copy(file, copyDir);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return FileVisitResult.CONTINUE;
    }

    // The relativized method is used to get the relative path to the source root. Example below:
//    sourcePath = "FileTree\Dir2\Dir3\file1.txt";
//    sourceRoot = "FileTree\Dir2";
//    targetRoot = "FileTree\Dir4\Dir2Copy";
//    relativizedPath = sourceRoot.relativize(sourcePath); // Which = "Dir3\file1.txt"
//    resolvedPathForCopy = targetRoot.resolve(relativizedPath); // Which = "FileTree\Dir4\Dir2Copy\Dir3\file1.txt"
}
// As we can see above the relativized path is the content of the directory that we are going to copy.
// Getting back at how we were copying file, it makes sense, as we are just copying from "Dir3" we don't actually need
// to copy the root folder. The root folder will be created by the destination path, with the specified name given by
// the user.