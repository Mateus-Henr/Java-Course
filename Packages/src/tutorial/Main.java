package tutorial;

import org.w3c.dom.Node;

// Packages
// As there are lots of programmers worldwide, conflicts are inevitable.
// So mechanism is needed to fully specify class.
// They are used to make sure that people can reuse names.
// Packages are a way to grouping interfaces and classes together.
// Because packages creates a new namespace, class and interface name conflicts are avoided.
// Classes within a package can have unrestricted access to one another while still restricting access
// for classes outside the package.

// java.lang is automatically imported when we create a Java application (Classes, Integer, etc).

// Import of a package
// import org.w3c.dom.Node;

// Gives an error because we can't have two packages ending with the same name
// import org.w3c.dom.Node;
// import javax.xml.soap.Node;

// One way of using packages that end with the same name is to import one and use the other one where you defining
// the package

public class Main
{
    public static void main(String[] args)
    {
        // Another way of getting a package (not imported)
        org.w3c.dom.Node node = null;
        Node a = null;
    }

}
