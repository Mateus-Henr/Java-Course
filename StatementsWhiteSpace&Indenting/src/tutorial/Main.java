package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        int myVariable = 50; // Statement = dataType + variable + value + ; > So the line of code here is an statement.
        myVariable++; // > Another statement
        myVariable--;

        System.out.println("This is a statement as well"); // Sout is a method call and method calls are statements;

        System.out.println("This is " +
                "another " +
                "statement. "); // Statements can have in multiple lines

        int anotherVariable = 50; myVariable--; System.out.println("Statements in the same line");

        // Whitespace is the space between your code, for example assigning variables.
        int
                myVariable2
                =
                50
                ;  // Internally Java deletes spaces.

        // Indentation - Act of indenting your code to make it more readable. Putting the code in blocks. Example:
        if (myVariable == 0) {
            System.out.println("This sout is indented by the if.");
        }
        else {
        System.out.println("This code is not indented by the else.");
        }
        // Indenting helps the readability of the logic flow of the code.
    }
}
