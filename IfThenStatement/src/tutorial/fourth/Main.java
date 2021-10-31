package tutorial.fourth;

public class Main
{
    public static void main(String[] args)
    {
        boolean isCar = false;
        isCar = true;
        boolean wasCar = isCar ? true : false; // First operand if the condition is true | second operand if the condition is false.
        if (wasCar)
        {
            System.out.println("wasCar is true");
        }
        // The ternary operator is a shortcut for the if/else condition.

        int ageOfClient = 20;
        boolean isEighteenOrOVer = (ageOfClient == 20) ? true : false;
        // Condition: ageOfClient == 20
        // If true: true
        // If false: false
    }
}
