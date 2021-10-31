package tutorial;

public class Main
{
    int myMinIntValue = Integer.MIN_VALUE;
    byte myMinByteValue = Byte.MIN_VALUE;
    short myMinShortValue = Short.MIN_VALUE;

    int myTotal = (myMinIntValue / 2); // Basic arithmetic
    // byte myNewByteValue = (myMinByteValue / 2); // Got an error here because the value used is int, which is used by default.
    byte myNewByteValue = (byte) (myMinByteValue / 2); // Here we're casting the result to the will data type.
    // Casting means to treat or convert a number from one type to another.

    short myNewShortValue = (short) (myMinShortValue / 2);
    // Always use an Integer, unless you've got a good reason for not to.
}
