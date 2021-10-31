package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        int myValue = 1000;
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("myMinIntValue: " + myMinIntValue + "\nmyMaxIntValue: " + myMaxIntValue);

        System.out.println("Busted MAX value = " + (myMaxIntValue + 1));
        System.out.println("Busted MIN value = " + (myMinIntValue - 1));

        int myMaxIntTest = 2_147_483_647;
        System.out.println("\nmyMaxIntTest: " + myMaxIntTest);

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("\nmyMinByteValue: " + myMinByteValue + "\nmyMaxByteValue: " + myMaxByteValue);


        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("\nmyMinShortValue: " + myMinShortValue + "\nmyMaxShortValue: " + myMaxShortValue);

        long myLongValue = 100L; // Use "L" for long values because by default Java treats numbers as Integers.

        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("\nmyMinLongValue: " + myMinLongValue + "\nmyMaxLongValue: " + myMaxLongValue);

        long bugLingLiteralValue = 2_147_483_647_123L; // Without "L" an error appears because Java treats the number as an Integer.
        System.out.println(bugLingLiteralValue);

        short bigShortLiteralValue = 32767; // Maximum value for short

        // byte - Occupies 8 bits (width of 8)
        // short - Occupies 16 bits (width of 16)
        // int - Occupies 32 bits (width of 32)
        // long - Occupies 64 bits (width of 64)
    }

}
