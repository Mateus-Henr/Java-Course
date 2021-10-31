package challenge.third;

public class Main
{
    public static void main(String[] args)
    {
        int primeFound = 0;

        for (int i = 1; i <= 100; i++)
        {
            if (isPrime(i))
            {
                System.out.println("The number " + i + " is a prime number.");
                primeFound++;
            }

            if (primeFound > 2)
            {
                System.out.println("Exiting the for loop.");
                break;
            }
        }

        System.out.println("Total of prime numbers found = " + primeFound);
    }

    // A prime number can be divided evenly only by one or by itself and needs to be greater than one.
    public static boolean isPrime(int n)
    {
        if (n == 1)
        {
            return false;
        }

        // Optimizing code here by dividing n by two (division of a number concept).
//        for (int i = 2; i <= (n / 2); i++)
//        {
//            if (n % i == 0)
//            {
//                return false;
//            }
//        }

        // To optimize even more we could've used:
        // Since the number of cases that we would need to check would be less.
        // If you take the square root of a number it less than half of the number.
        // Take for instance, 24. the square root of 24 is about 4.9.
        // If you only iterate 4 times, that is less than half of 24 which is 12.  (n/2)
        for (int i = 2; i <= (long) Math.sqrt(n); i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

}
