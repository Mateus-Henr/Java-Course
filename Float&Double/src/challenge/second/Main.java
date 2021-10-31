package challenge.second;

public class Main
{
    public static void main(String[] args)
    {
        double pounds = 200d;
        double kilograms = pounds * 0.45359237d;
        System.out.println(pounds + " pounds to kilograms is equal to " + kilograms + " kg.");

        double pi = 3.1415927d;
        double anotherNumber = 3_000_000.4_567_890d;
        System.out.println(pi);
        System.out.println(anotherNumber);

        // For precise operations neither float or double are recommended, it's a Java limitation.
        // You can use BigDecimal to overcome this problem.
    }
}
