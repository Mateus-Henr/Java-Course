package challenge.second;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("10,000 at 2% interest = " + calculateInterest(10000.00, 2.0));
        System.out.println("10,000 at 3% interest = " + calculateInterest(10000.00, 3.0));
        System.out.println("10,000 at 4% interest = " + calculateInterest(10000.00, 4.0));
        System.out.println("10,000 at 5% interest = " + calculateInterest(10000.00, 5.0));

        for (int i = 0; i < 5; i++)
        {
            System.out.println("Loop " + i + " hello!");
        }

        // If you put invalid values in the for loop, it either loops infinitely or it doesn't even loop at all.
        for (int i = 8; i >= 2; i--)
        {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.00, i)));
        }
    }

    private static double calculateInterest(double amount, double interestRate)
    {
        return (amount * (interestRate / 100));
    }

}
