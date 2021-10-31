package challenge.second;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 103213, 4324, 435, 4234, 1322, 34, 2};
        System.out.println("Unmodified array: " + Arrays.toString(array));
        System.out.print("Reversed Array: ");
        reverse(array);
    }

    private static void reverse(int[] arrayToRevert)
    {
        int temp = 0;

        for (int i = 0; i < arrayToRevert.length; i++)
        {
            if (arrayToRevert.length % 2 == 0)
            {
                if (i == arrayToRevert.length - i)
                    break;
            }
            else
            {
                if (i == arrayToRevert.length - i - 1)
                    break;
            }

            temp = arrayToRevert[i];
            arrayToRevert[i] = arrayToRevert[arrayToRevert.length - i - 1];
            arrayToRevert[arrayToRevert.length - i - 1] = temp;
        }

        System.out.print("[");
        for (int i = 0; i < arrayToRevert.length; i++)
        {
            if (i == arrayToRevert.length - 1)
            {
                System.out.print(arrayToRevert[i]);
            } else
            {
                System.out.print(arrayToRevert[i] + ", ");
            }
        }
        System.out.print("]");
    }

}
