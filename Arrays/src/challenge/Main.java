package challenge;

import java.util.*;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[] array = getIntegers(5);
        int[] newArray = sortIntegers(array);
        printArray(newArray);
    }

    public static int[] sortIntegers(int[] array)
    {
//        int[] sortedArray = new int[array.length];
//        for(int i=0; i<array.length; i++) {
//            sortedArray[i] = array[i];
//        }
        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int temp;
        while (flag)
        {
            flag = false;
            // element 0     160
            // element 1     50
            // element 2     40

            for (int i = 0; i < sortedArray.length - 1; i++)
            {
                if (sortedArray[i] < sortedArray[i + 1])
                {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    public static void printArray(int[] arrayToPrint)
    {
        System.out.print("Array formatted [");
        for (int i = 0; i < arrayToPrint.length; i++)
        {
            if (i == arrayToPrint.length - 1)
                System.out.print(arrayToPrint[i]);
            else
                System.out.print(arrayToPrint[i] + ", ");
        }
        System.out.print("]");
    }

    public static int[] getIntegers(int capacity) {
        System.out.println("Enter the value for your array. Obs: Up to " + capacity + " values.\r");
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++)
        {
            array[i] = scanner.nextInt();
        }

        return array;
    }

}