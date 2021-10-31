package challenge;

public class Series
{
    public static int nSum(int startNumber)
    {
        int sum = 0;

        for (int i = 0; i <= startNumber; i++)
        {
            sum += i;
        }

        return sum;
    }

    // Tim's Code
//    public static long nSum(int n) {
//        return (n * (n + 1)) /2;
//    }

    public static int factorial(int numberToFactor)
    {
        int result = 1;
        for (int i = numberToFactor; i > 0; i--)
        {
            result *= i;
        }

        return result;
    }

    public static int fibonacci(int numberOfTems)
    {
        int head = 1;
        int node = 0;
        int tail = 0;

        for (int i = 0; i < numberOfTems; i++)
        {
            if (i > 0)
            {
                tail = head + node;
                head = node;
                node = tail;
            }
        }

        return tail;
    }

}
