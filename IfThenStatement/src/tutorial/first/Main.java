package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        // The if-then statement is the most basic of all the control flow statements.
        // It tells your program to execute a certain section of code only if a particular test evaluates to true.
        // Know as conditional logic.
        // Conditional logic uses specific statements in Java that allow us to check a condition.

        boolean isAlien = false; // Assigns a value to a variable
        if (isAlien == false) // "==" is used for comparison
            System.out.println("It is not an alien!"); // One way (NOT THE BEST)
            System.out.println("And I'm not scared of aliens"); // This line is always executed.

        if (!isAlien)
        {
            System.out.println("It is not an alien!"); // The BEST WAY
        }

    }
}
