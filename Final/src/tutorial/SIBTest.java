package tutorial;

// Static Initialization Blocks (SIB)
// Instance constructors are those that are initialized when we create an instance of a class.
// They are just executed once when the class is loaded into the project.

// All static final variable must be initialized by the time all static initialization blocks terminate. That said,
// SIB is used to initialize these type of variables.

public class SIBTest
{
    public static final String owner;

    // STATICS are called first.

    static
    {
        owner = "tim";
        System.out.println("SIBTest static initialization block called.");
    }

    public SIBTest()
    {
        System.out.println("SIB constructor called.");
    }

    static
    {
        System.out.println("2nd initialization block called");
    }

    public void someMethod()
    {
        System.out.println("someMethod called");
    }

}
