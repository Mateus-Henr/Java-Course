package tutorial;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int myIntValue = 10;
        int anotherIntValue = myIntValue;
        System.out.println("\n----------------Default----------------");
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        System.out.println("\n-----------Incremented Value-----------");
        anotherIntValue++;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        int[] myIntArray = new int[5];
        int[] anotherIntArray = myIntArray; // Point to the same address
        System.out.println("\n----------------Default----------------");
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

        System.out.println("\n-----------Incremented Array-----------");
        anotherIntArray[0] = 1;
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

        System.out.println("\n------------Modified Array------------");
        anotherIntArray = new int[] {4, 5, 6, 7, 8}; // Now it points to another place in memory
        modifyArray(myIntArray);
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

    }

    private static void modifyArray(int[] arrayToModify) { // This parameter points to the same place in memory as myIntArray
        arrayToModify[0] = 2;

        arrayToModify = new int[] {1, 2, 3, 4, 5}; // New array

        System.out.println("arrayToModify = " + Arrays.toString(arrayToModify));
    }

}
