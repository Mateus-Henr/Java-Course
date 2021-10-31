package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        int value = 3;

        if (value == 1)
        {
            System.out.println("Value was 1.");
        }
        else if (value == 2)
        {
            System.out.println("Value was 2.");
        }
        else
        {
            System.out.println("Was not 1 or 2.");
        }

        // The switch statement is used when you have multiple values to test.
        // But you can do the same thing using if statements.
        // One important thing is when using the switch statement you can just test one variables, but
        // when using if statement you can test different variables.
        int switchValue = 4;

        switch (switchValue)
        {
            case 1: // Testing for the value 1 (equivalent to "if (value == 1)")
                System.out.println("Value was 1.");
                break; // Terminates the enclosing switch statement. So it executes the code after the switch statement.
            case 2:
                System.out.println("Value was 2.");
                // Without the break statement you can get unpredictable results.
                // If we comment this break, if the flow of execution enters here, it will continue until it gets to a
                // break, so it will execute the next case as well.
                break;
            case 3:
            case 4: // Checking multiple values
            case 5:
                System.out.println("Was a 3, or a 4 , or a 5.");
                System.out.println("Actually it was a " + switchValue);
                break;
            default: // Basically an "else"
                System.out.println("Was not 1, 2, 3, 4 or 5.");
                // As it's the last line of the switch statement we don't really need this break here,
                // but it's good practise to do so.
                break;
        }
    }

}
