package challenge;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean hasEnteredInitialNumber = false; // This is called a "flag".

        while (true)
        {
            System.out.print("Enter number: ");

            if (scanner.hasNextInt())
            {
                int userNumber = scanner.nextInt();

                if (userNumber > max)
                {
                    max = userNumber;
                }

                if (userNumber < min)
                {
                    min = userNumber;
                }

                hasEnteredInitialNumber = true;
            }
            else
            {
                break;
            }
        }

        if (hasEnteredInitialNumber)
        {
            System.out.println("Minimum = " + min + "\nMaximum = " + max);
        }
        else
        {
            System.out.println("No numbers were entered.");
        }
        scanner.close();
    }

}
