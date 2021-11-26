package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        int myVariable = 50; // Statement = dataType + variable + value + ; > So the line of code here is an statement.
        myVariable++; // > Another statement
        myVariable--;

        System.out.println("This is a statement as well"); // "sout" is a method call and method calls are statements;

        System.out.println("This is " +
                                   "another " +
                                   "statement. "); // Statements can have in multiple lines

        // If your statement is valid Java doesn't care.
        System.out.println("Statements in the same line");
        int anotherVariable = 50;
        myVariable--;

        // Whitespace is the space between your code, for example assigning variables. Usually added for human
        // readability purposes. It doesn't take up any memory in your final program.
        int
                myVariable2
                =
                50;  // Internally Java deletes spaces.

        // Indentation - Act of indenting your code to make it more readable. Putting the code in blocks. Example:
        if (myVariable == 0)
        {
            System.out.println("This sout is indented by the if.");
        }
        else
        {
            System.out.println("This code is not indented by the else.");
        }
        // Indenting helps the readability of the logic flow of the code.
    }
    // A statement forms a complete unit of execution.
    // The three statements are:
    // Declaration statement -> Declaring variables.
    // Expression statement -> Assignment expressions, "++" and "--", method calls and object creation.
    // Control flow statement -> Conditions, looping and branching statements (break, continue, etc).
}

// Code block are the parts of the code surrounded by "{}".