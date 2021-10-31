package challenge.secondImproved;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        reverse(new int[] {1, 2, 3,4, 5, 6, 7, 8, 9, 10, 11});
    }

    private static void reverse(int[] arrayToReverse) {
        System.out.println("Array = " + Arrays.toString(arrayToReverse));

        int maxIndex = arrayToReverse.length - 1;
        int halfWay = arrayToReverse.length / 2;
        for (int i = 0; i < halfWay; i++) {
            int temp = arrayToReverse[i];
            arrayToReverse[i] = arrayToReverse[maxIndex - i];
            arrayToReverse[maxIndex - i] = temp;
        }

        System.out.println("Reversed array = " + Arrays.toString(arrayToReverse));
    }
}
