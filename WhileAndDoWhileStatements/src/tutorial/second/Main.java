package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        int number = 0;

        while (number < 15)
        {
            number++;

            if (number <= 5)
            {
                System.out.println("Skipping number " + number);
                continue; // Using this the executing will bypass what's below it.
            }

            // This part will only be executed if the number is greater than 5.
            System.out.println("number = " + number);

            if (number >= 10)
            {
                System.out.println("Breaking at " + number);
                break;
            }
        }
    }

}
