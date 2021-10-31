package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        // Primitive Data Types
        // byte
        // short
        // int
        // long
        // float
        // double
        // char
        // boolean
        // Classes == super data type

        // String
        // It's a sequence of characters.
        // It's not a primitive type.
        // It's limited to the MAX_VALUE of an int.

        String myString = "This is a string";
        System.out.println("myString is equal to " + myString);
        myString = myString + ", and this is more.";
        System.out.println("myString is equal to " + myString);
        myString = myString + " \u00A9 2019";
        System.out.println("myString is equal to " + myString);

        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println(numberString);

        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt; // Converts the int to String (Java does it automatically)
        System.out.println("LastString is equal to " + lastString);

        double doubleNumber = 120.47d;
        lastString = lastString + doubleNumber; // Here a new String is created with the lastString + doubleNumber. (Strings are immutable)
        System.out.println("LastString is equal to " + lastString); // After creating a new String the old one is discarded.

        // Strings in Java are Immutable, you can not change a string after it's created.
        // What happens it a new String is created.
        // StringBuffer is better for changing String without creating a new one.
    }
}
