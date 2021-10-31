package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        // Double is a double precision number and Float is a single precision number.
        // Precision refers to the format and amount of space occupied by the type. Single = 32 bits and Double = 64 bits.
        // Therefore double is more precise since it has more number meaning that the obtained number is closer to a
        // specific number than the float would be. The more precise the more memory used.

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimum value = " + myMinFloatValue);
        System.out.println("Float maximum value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimum value = " + myMinDoubleValue);
        System.out.println("Double maximum value = " + myMaxDoubleValue);

        int myIntValue = 5;
        //  float mtFloatValue = 5.25; // Error since when we use decimal numbers double is used by Java by default.
        float myFloatValue = 5.25f;
        double myDoubleValue = 5.25d; // Letter to confirm the data type. IT'S A GOOD PRACTISE TO DO THIS.

    }
}
