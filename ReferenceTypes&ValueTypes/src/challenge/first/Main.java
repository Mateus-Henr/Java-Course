package challenge.first;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("How many values would you like to enter? ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Welcome to the program to find your minimum value!");

        System.out.println("Enter " + capacity + " values: \r");
        int[] userArray = readIntegers(capacity);
        scanner.close();

        System.out.println("The minimum value of your array is " + findMin(userArray));

        System.out.println("The maximum value of your array is " + findMax(userArray));
    }

    private static int[] readIntegers(int capacity)
    {
        int[] userValues = new int[capacity];

        for (int i = 0; i < userValues.length; i++)
        {
            userValues[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return userValues;
    }

    private static int findMin(int[] arrayToFindMin)
    {
        int minValue = Integer.MAX_VALUE;

        for (int element : arrayToFindMin)
        {
            if (element < minValue)
            {
                minValue = element;
            }
        }

        return minValue;
    }

    private static int findMax(int[] arrayToFindMax)
    {
        int maxValue = Integer.MIN_VALUE;

        for (int element : arrayToFindMax)
        {
            if (element > maxValue)
            {
                maxValue = element;
            }
        }

        return maxValue;
    }

}
