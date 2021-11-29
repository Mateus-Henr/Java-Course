package tutorial;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // "System.out" is used to display text into the console, "System.in" is used when we want to input values.
        Scanner scanner = new Scanner(System.in);

        // We can pass primitive types to variables using a Scanner.
        System.out.println("Enter your year of birth: ");

        // This method checks if the next input entered is a number.
        // Allowing us to manage errors if the inserted value isn't number.
        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) // If it's a valid number
        {
            int yearOfBirth = scanner.nextInt(); // This method parses the typed value to an int value.

            // Whenever we enter a number in the console we press the "Enter" keyword and by doing it, ends the line.
            // It's recommended after "nextInt" to call "nextLine()" without assigning it to a variable, this way we will
            // be handling the "Enter" issue.
            // Internally, Scanner looks for a line separator and by pressing "Enter" we are typing a line separator, and
            // it's interpreted as input, in this case the "name".
            scanner.nextLine(); // Handle next line character ("Enter" key)

            System.out.println("Enter your name: ");
            String name = scanner.nextLine(); // It reads a line of input from the console.

            int age = 2021 - yearOfBirth; // Calculating age

            if (age >= 0 && age <= 100)
            {
                System.out.println("Your name is: " + name + ", and you are " + age + " years old.");
            }
            else
            {
                System.out.println("Invalid year of birth.");
            }
        }
        else
        {
            System.out.println("Unable to parse year of birth.");
        }

        // We have to close the Scanner after using it.
        // By closing it, it releases the memory that the Scanner was using.
        scanner.close();
    }

}
