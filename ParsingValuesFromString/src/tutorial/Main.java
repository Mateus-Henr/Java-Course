package tutorial;

// Parsing Values from a String
// Normally is necessary to do it when using an input from the user.
public class Main
{
    public static void main(String[] args)
    {
        String numberAsString = "2018";
        System.out.println("numberAsString = " + numberAsString);

        // Parsing methods
        // To parse a String we need to use the wrapper class for a specific type.
        // If we try to use the method, let's say with a letter amongst the number, a "NumberFormatException" will
        // happen.
        int number = Integer.parseInt(numberAsString);
        System.out.println("number = " + number);

        // When adding a number to a String, Java will automatically transform the number to a String and then
        // concatenate it to the existing String.
        numberAsString += 1;
        number += 1; // Normal mathematical operation

        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);

        System.out.println("\nparseDouble method");
        numberAsString = "2018.125";
        double doubleNumber = Double.parseDouble(numberAsString);
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("doubleNumber = " + doubleNumber);
    }

}
