package tutorial.second;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example
{
    // In a real world app, the exception would be caught when calling the "divide" method.
    public static void main(String[] args)
    {
        try
        {
            int result = divide();
            System.out.println(result);
        }
        // Using bit wise including or.
        catch (ArithmeticException | NoSuchElementException e) // Catching more than one exception.
        {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down.");
        }
    }

    private static int divide()
    {
        int x, y;
//        // Neater way to write code.
//        try
//        {
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);

        return x / y;

//        }
//        // When an exception happens the "catch" blocks are checked in order.
//        catch (NoSuchElementException e)
//        {
//            throw new NoSuchElementException("No suitable input.");
//        }
//        catch (ArithmeticException e)
//        {
//            throw new ArithmeticException("Attempt to divide by zero.");
//        }
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
            }
            catch (InputMismatchException e)
            {
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9: ");
            }
        }
    }

}
