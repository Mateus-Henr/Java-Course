package challenge;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(sumDigits(451));
        System.out.println(sumDigits(123));
        System.out.println(sumDigits(4354));
        System.out.println(sumDigits(-32));
    }

    private static int sumDigits(int number)
    {
        if (number < 10)
        {
            return -1;
        }

        int sum = 0;

        int lastDigit;
        // Using the remainder like: 125 -> 125 / 10 = 12 -> 12 * 10 = 120 -> 125 - 120 = 5
        // As it's an int number the decimal places are discarded.
        while ((lastDigit = number % 10) > 0)
        {
            sum += lastDigit;
            number = number / 10; // Taking the digit out because it has already been checked.
        }

        return sum;
    }

}
