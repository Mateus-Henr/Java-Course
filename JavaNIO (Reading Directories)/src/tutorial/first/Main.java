package tutorial.first;

import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {
        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");

        // The following method returns a stream of paths that needs to be closed.
        // The "newDirectoryStream" method accepts a second parameter that's is a filter. It can be used to
        // filter to get only the ".dat" files for example.
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, "*.dat"))
        {
            for (Path file : contents)
            {
                // Just the direct descendants will be shown here, if there's a folder with a file within it, it won't
                // be shown here, just the folder's name. (First level of content)
                System.out.println(file.getFileName());
            }
        }
        catch (IOException | DirectoryIteratorException e) // Using pipe to catch both exceptions
        {
            System.out.println(e.getMessage());
        }
    }

}

// Glob syntax
// The "*" character matches any string.
// The "?" matches exactly one character.
// Exs:
// *.dat
// *.{dat, txt} will both paths.
// myFile*
// b?*.txt (matches any paths that are at least two characters long and begin with the character b (the ? forces
//          a second character, and the * matches 0 or more characters))
// OBS: They don't operate in file attributes.