package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        int myValue = 1000;
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("myMinIntValue: " + myMinIntValue + "\nmyMaxIntValue: " + myMaxIntValue);

        System.out.println("Busted MAX value = " + (myMaxIntValue + 1)); // Overflow
        System.out.println("Busted MIN value = " + (myMinIntValue - 1)); // Underflow
        // Whey you try to put a number greater than the maximum value the computer will skip to the min value - It's like a circle

        // int myMaxIntTest = 2147483648; Error the max value for an integer is 2147483647
        int myMaxIntTest = 2_147_483_647; // You can use underscore to make the readability easier. But the underscore doesn't appear when inputting.
        System.out.println("myMaxIntTest: " + myMaxIntTest);
    }

}
