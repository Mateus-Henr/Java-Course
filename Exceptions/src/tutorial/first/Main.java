package tutorial.first;

import java.util.InputMismatchException;
import java.util.Scanner;


// An exception is an event that occurs during the execution of a program that disrupts the normal flow of the program
// instructions (an error).
// By specifying the exception to be caught we increases the code's readability.
// If we don't catch an exception it will propagate to the calling method.
public class Main
{
    public static void main(String[] args)
    {
        int x = 98;
        int y = 0;
        System.out.println(divideByBYL(x, y));
        System.out.println(divideEADFP(x, y));
//        System.out.println(divide(x, y)); // This crashes

        int z = getInt();
        System.out.println("z is " + z);

        int a = getIntBYL();
        System.out.println("a is " + a);

        int b = getIntEAFP();
        System.out.println("b is " + b);
    }

    private static int getInt()
    {
        return new Scanner(System.in).nextInt();
    }

    private static int getIntBYL()
    {
        boolean isValid = true;
        System.out.println("Please enter an integer: ");
        String input = new Scanner(System.in).next();

        for (int i = 0; i < input.length(); i++)
        {
            if (!Character.isDigit(input.charAt(i)))
            {
                isValid = false;
            }
        }

        if (isValid)
        {
            return Integer.parseInt(input);
        }

        return 0;
    }

    // Less code
    private static int getIntEAFP()
    {
        System.out.println("Please enter an integer: ");

        try
        {
            // We can use return in a try.
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e)
        {
            return 0;
        }
    }

    private static int divideByBYL(int x, int y) // "Look before you leave" scenario
    {
        if (y != 0)
        {
            return x / y;
        }

        return 0;
    }

    private static int divideEADFP(int x, int y) // "Ask for forgiveness and permission" scenario
    {
        try
        {
            return x / y;
        } catch (ArithmeticException e)
        {
            return 0;
        }
    }

    private static int divide(int x, int y)
    {
        return x / y;
    }

}
