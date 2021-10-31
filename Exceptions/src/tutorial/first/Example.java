package tutorial.first;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Java prints a stack trace when an exception occurs.
// The stack trace (in the case of exceptions) shows the call stack, which is a list of all the method calls at
// the point where the project crashes.

// Every time a new method is called, this is placed onto the stack and when a method returns, it's then removed
// from the stack.

// Exceptions are subclasses of the Exception class and Exception extends Throwable
// The Throwable constructor fills in the stack trace for the exception.

// The exception climbs up the hierarchy in the stack.
// We can use the overloaded constructor to provide more information about an exception and that's the main reason
// why we throw an exception back.
public class Example
{
    public static void main(String[] args)
    {
        int result = divide();
        System.out.println(result);
    }

    private static int divide()
    {
        int x, y;
        // If we press Ctrl + D, it'll throw an exception, it will be caught, but it'll be thrown again when calling
        // the method again.
        try
        {
            x = getInt();
            y = getInt();
        } catch (NoSuchElementException e) // Keep the "catch" blocks as simple as possible.
        {
            // It's important to know to not leave anything that may cause an exception inside the "catch".
            throw new ArithmeticException("No suitable input.");
        }

        System.out.println("x is " + x + ", y is " + y);

        try
        {
            return x / y;
        } catch (ArithmeticException e)
        {
            throw new ArithmeticException("Attempt to divide by zero.");
        }
    }

    private static int getInt()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        while (true)
        {
            try
            {
                return s.nextInt();
            } catch (InputMismatchException e)
            {
                // Go around again. Read past the end of the line in the input first.
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9: ");
            }
        }
    }

}
