package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("10,000 at 2% interest = " + calculateInterest(10000.00, 2.0));
        // We can get around this problem of code repetition by using the "for" statement ("for loop")
        // Basically it performs a loop a certain amount of times until a condition is satisfied.
        System.out.println("10,000 at 3% interest = " + calculateInterest(10000.00, 3.0));
        System.out.println("10,000 at 4% interest = " + calculateInterest(10000.00, 4.0));
        System.out.println("10,000 at 5% interest = " + calculateInterest(10000.00, 5.0));

        // Structure of a "for" loop
        // for (init; termination; increment)
        // init = The code that is going to be initialized once at the start of the loop.
        // termination = Tell the "for" loop at what point we want to exit.
        // increment = The expression that is evoked after each iteration of the loop.

        // Here "i" is a special variable, since it only works/exists inside the loop enclosure. (Also the loop's start)
        // So "i" can be used again outside of the "for" loop.
        // It will stop when "i" is 5.
        // While "i" is not 5 it's incremented one.
        // It's very typical to start at 0, since different parts of Java start at 0, i.e. arrays.
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Loop " + i + " hello!");
        }
    }

    private static double calculateInterest(double amount, double interestRate)
    {
        return (amount * (interestRate / 100));
    }

}

// The increment doesn't need to be "++", it could be "i = i + 1", therefore the value can be altered.
// It executes while the "termination" code is true.

// for (int number = 1; number < 7; number += 2)
// {
//      System.out.println("Number = " + number);
// }
//
// OUTPUT
// Number = 1
// Number = 3
// Number = 5

// Example of for loop that never executes, since the given values are invalid (the "termination" condition is false).
// Therefore it jumps out the "for" loop.
// for (int number = 1; number < 0; number += 2)
// {
//      System.out.println("Number = " + number);
// }

// Example of for loop that never ends, since the condition is always true. It will only stop when it reaches
// the maximum memory of an integer.
// for (int number = 100; number > 0; number += 10)
// {
//      System.out.println("Number = " + number);
// }