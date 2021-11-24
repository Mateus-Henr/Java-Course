package tutorial;

public class Main
{
    // Keywords are words that have a specific meaning in the Java language (reserved words).
    // They are usually represented by a different colour on IntelliJ.
    // They can't be used as to name code written by you.
    public static void main(String[] args)
    {
        // int int = 5; // Showing that we can't use this.
        int int2 = 5;
        // false, true, null
        // A mile is equal to 1.609344
        // The expression in the line below is: kilometers = (100 * 1.609344), the rest is NOT an expression.
        double kilometers = (100 * 1.609344);
        System.out.println("Value in kilometers " + kilometers);

        int highSCore = 50; // Expression: highSCore = 50
        if (highSCore == 50) // Code between the if is an expression
        {
            // Code between parenthesis is an expression. Anything between brackets is an expression.
            System.out.println("This is an expression");
        }
    }

    // Naming convention
    // It's an agreed scheme for naming things, it makes the code easier to read.
    // It's best practise to follow them.
    // For more information: https://google.github.io/styleguide/javaguide.html
    // When naming variables LowerCamelCase is used and the name of the variable must give some idea of its purpose.

}
