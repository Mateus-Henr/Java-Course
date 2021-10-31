package tutorial.third;

public class Main
{
    public static void main(String[] args)
    {
        int topScore = 80;
        int secondTopScore = 95;
        if ((topScore > secondTopScore) && (topScore < 100)) // Parenthesis help to clarify your code.
        {
            System.out.println("Greater than second top score and less than 100");
        }
        // || requires just one condition to be true.
        if ((topScore > 90) || (secondTopScore <= 90))
        {
            System.out.println("Either or both conditions are true.");
        }
    }
}
