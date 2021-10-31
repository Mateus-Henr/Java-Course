package first;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

public class Main
{
    public static void main(String[] args)
    {
        // int[] myVariable = new int[50]; First way to initialize

        // int[] myVariable;
        // myVariable = new int[10]; Second way to initialize

        // int[] myVariable = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; Third way to analyze (Initializes 10 elements)

        double quantityOfElements = 13;

        double[] myDoubleArray = new double[(int)quantityOfElements];
        int[] myVariable = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        myVariable[5] = 15;

        // Initializing array
        for (double i = 0.0; i < (quantityOfElements / 10); i += 0.1) {
            myDoubleArray[(int)(i*10)] = i;

        }

        /*// Printing it out
        for (int i = 0; i < myDoubleArray.length; i++) {
            System.out.println("myDoubleArray[" + i + "]: " + myDoubleArray[i]);
        }*/

        printArray(myDoubleArray);

        System.out.println("myVariable[5]: " + myVariable[5]);

    }

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("myDoubleArray[" + i + "]: " + array[i]);
        }
    }

}
