package challenge;

public class Main
{
    public static void main(String[] args)
    {
        int sum = 0;
        int counter = 0;

        for (int num = 1; num <= 1000; num++)
        {
            // Multiple parenthesis are being used to avoid problems with operator precedence and to facilitate
            // readability.
            if ((num % 3 == 0) && (num % 5 == 0))
            {
                System.out.println("Found number = " + num);
                sum += num;
                counter++;
            }

            if (counter == 5)
            {
                break;
            }
        }

        System.out.println("The sum of the numbers divided by 3 and 5 in the interval of 1 to 1000 is equal to " + sum);
    }

}
