package tutorial;

public class StaticTest
{
    private static int numInstances = 0; // If it's not static when the program will have different instances of it.
    private String name;

    public StaticTest(String name)
    {
        this.name = name;
        numInstances++;
    }

    // By making this method static we don't have to create instances to access the method.
    public static int getNumInstances()
    {
        return numInstances;
    }

    public String getName()
    {
        return name;
    }

}
