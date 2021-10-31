package second.mine;

import java.util.Scanner;

public class Main
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[] userNumbers = new int[10];

        boolean quit = false;
        int position = 0;
        while (!quit)
        {
            try
            {
                System.out.print("Type a number for the " + (position + 1) + "° position: ");
                int userNumber = sc.nextInt();
                userNumbers[position] = userNumber;
            } catch (Exception e)
            {
                System.out.println(e);
            }

            position++;

            if (position > userNumbers.length - 1) {
                quit = true;
            }
        }

        System.out.println("\n");
        printArray(userNumbers);
    }

    public static void printArray(int[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.println((i + 1) + "° element is " + arrayToPrint[i]);
        }
    }

}
