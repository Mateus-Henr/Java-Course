package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        // "=" is different from "==".
        int newValue = 50; // Assigning
        if (newValue == 50) // Comparing
        {
            System.out.println("This is true");
        }

        boolean isCar = false;
        if (isCar = true) // When assigning a boolean like this, if the value's true the if is gonna happen. // The value is assigned then it returns the value of the variable.
        {
            System.out.println("This is true.");
        }

        if (!isCar) // "!" tests the opposite value
        {
            System.out.println("This is not supposed to happen.");
        }
    }
}
