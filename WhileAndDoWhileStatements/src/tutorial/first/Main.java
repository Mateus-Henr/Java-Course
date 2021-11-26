package tutorial.first;

public class Main
{
    // When we want to loop until a certain expression evaluates to false we use the "while" loop.
    // Most of the time because you don't know how many times you want to loop ahead of time.
    public static void main(String[] args)
    {
        System.out.println("While With Condition Loop");
        int count = 1; // We need to create our loop's counting mechanism. Usually before the "while" statement.
        while (count != 6) // If this expression is evaluated to false the code within the while loop will never be executed.
        {
            System.out.println("Count value is " + count);
            count++;
        }

        // Another example of "while" statement
        System.out.println("While (true) Loop");
        count = 1;
        while (true)
        {
            if (count == 6)
            {
                break; // Getting out of the loop if the condition is matched.
            }

            System.out.println("Count value is " + count);
            count++; // Always make sure that you've got the variable implemented, otherwise it's going to loop endlessly.
        }

        // Do While loop
        // This type of loop has the advantage that it will always execute at least once. Just then the condition is
        // checked.
        // And it can execute more times depending on the condition given to it.

        System.out.println("Do While Loop");
        count = 6;
        do // Guaranteed to execute at least once.
        {
            System.out.println("Count value was " + count);
            count++;

            // "break" inside the "do while" loop is also possible.
            if (count > 100)
            {
                break;
            }

        } while (count != 6); // Expression that says if we are going to leave the while loop or not.

//        // Equivalent using the "for" statement
//        for (count = 1; count != 6; count++) // Example of reusing a variable for the "for" loop.
//        {
//            System.out.println("Count value is " + count);
//        }
        // Another difference between the "while" and "for" loops is that whilst the "while" loop does something while
        // a condition is true, the "for" loop does the opposite (while a condition is false).

    }

}
