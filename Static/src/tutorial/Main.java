package tutorial;

public class Main
{
    public static int multiplier = 7;

    // The main method is static because Java doesn't need to instantiate it.
    // Until the program runs there's no class to call the methods on, so Java uses the class name to call the program.
    public static void main(String[] args)
    {
        // All of these instances share the same variable of "numInstances" of the "StaticTest" class.
        StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("2st Instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3st Instance");
        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        // Java can't allow the calling of non-static fields in static methods, because as static methods don't
        // need instance of the class they're are called first. So Java can't call non-static fields because the
        // instance of the class of the non-static fields doesn't even exist yet.
        int answer = multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("Multiplier is " + multiplier);
    }

    public static int multiply(int number)
    {
        return number * multiplier;
    }

}

// A static field (or class variable) is associated with the class rather than with any particular instance of it.
// There's only one copy of that variable in memory.

// Static methods and fields belong to the class and NOT to instances to the class.

// The IDE invokes a Java executable and passes to it the class name that contains the "main" method.