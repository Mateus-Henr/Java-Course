package tutorial.first;

public class CheckNumber
{
    public static void main(String[] args)
    {
        checkNumber(-1);
        checkNumber(0);
        checkNumber(100);
    }

    private static void checkNumber(int number)
    {
        if (number < 0)
        {
            System.out.println("The number " + number + " is negative.");
        }
        else if (number > 0)
        {
            System.out.println("The number " + number + " is positive.");
        }
        else
        {
            System.out.println("The number " + number + " is zero.");
        }
    }

}
