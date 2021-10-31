package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        int number = 4;
        int finishNumber = 20;

        while (number <= finishNumber)
        {
            number++; // The incrementation must come first if using continue such as how we are doing here.
            if (!isEvenNumber(number))
            {
                // It'll bypass all the code after this statement until it gets to the start of the loop again.
                continue; // Will increment the number again in order to not fall in the imaginary "else".
            }

            System.out.println("Even number " + number);
        }
    }

    private static boolean isEvenNumber(int number)
    {
        if ((number % 2) == 0)
        {
            return true;
        }

        return false;
    }

}
