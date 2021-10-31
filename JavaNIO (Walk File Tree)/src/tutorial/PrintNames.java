package tutorial;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// The JDK has got an implementation called SimpleFileVisitor and this class can be extended and you can overwrite
// just the methods that you want.
public class PrintNames extends SimpleFileVisitor<Path>
{
    // Accepts a reference to the file and a BasicAttributes instance. This is where you run the code that will
    // operate on the file (only called for files.)
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    // Accepts a reference to that directory and the BasicFileAttributes instance for the directory (called before
    // the visit to the directory).
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    // This method is only called when a file can't be accessed. The exception that is thrown is passed to the
    // method for you to modify it if you want. Can be called both (directories and files).
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
    {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    // Accepts a reference to that directory and an exception object. This method is only called after every
    // file have been visited. The exception object is used by the code to throw a feedback. In order to this
    // method to execute every file have to have been visited (some of them might be skipped), or if an exception
    // happens in the method before. Throws a bland exception if you don't pass one.
    // If you want to delete all the files/dir in a file tree you would have to use the "PostVisitDirectory", since
    // you need to delete the descendants as well.
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
    {
        return super.postVisitDirectory(dir, exc);
    }

    // Other constants
    // SKIP - When you want to skip a file/dir (Just works on "preVisitDirectory", otherwise it's a CONTINUE)
    // TERMINATE - When you want to finish the process

    // OBS: You can't assume which directory/file is going to be accessed first.
}
