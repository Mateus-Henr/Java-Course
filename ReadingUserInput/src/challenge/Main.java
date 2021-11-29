package challenge;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numbersEntered = 1;
        int sum = 0;

        while (numbersEntered <= 10)
        {
            System.out.print("Enter number #" + numbersEntered + ": ");

            if (scanner.hasNextInt()) // Checking if the value is valid.
            {
                sum += scanner.nextInt();
                numbersEntered++;
            }
            else
            {
                System.out.println("Invalid input.");
            }

            scanner.nextLine(); // Handles end of line, "Enter" key.
        }

        System.out.println("Sum = " + sum);
        scanner.close();
    }

}
