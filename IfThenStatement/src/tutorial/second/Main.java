package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        int topScore = 100;
        if (topScore == 100)
        {
            System.out.println("You got the high score!");
        }

        if (topScore != 100)
        {
            System.out.println("You didn't get the high score!");
        }

        if (topScore > 100)
        {
            System.out.println("There no score greater than 100!");
        }

        if (topScore >= 100)
        {
            System.out.println("Maximum score or invalid score!");
        }

        if (topScore < 100)
        {
            System.out.println("Unfortunately you didn't get the top score.");
        }

        if (topScore <= 100)
        {
            System.out.println("Maximum score or you didn't get the top score!");
        }

        topScore = 80;
        int secondTopScore = 60;
        if (topScore > secondTopScore && topScore < 100) // Both conditions need to be true, because we're using &&
        {
            System.out.println("Greater than second top score and less than 100");
        }
    }
}
