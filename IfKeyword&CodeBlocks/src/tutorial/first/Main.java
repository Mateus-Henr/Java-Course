package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        boolean gameOver = true;
        int score = 4000;
        int levelCompleted = 5;
        int bonus = 100;

        if (score == 5000)
            System.out.println("Your score was " + score); // Code block for if (Just works for one expression)
        System.out.println("This was executed");

        if (score == 5000) // Even if we have just one line the code gets cleaner with the code block;
        {
            System.out.println("Your score was " + score); // Using code block to use more than one line
            System.out.println("This was executed");
        }

        if (score < 4000 && score >= 1000) // Even if we have just one line the code gets cleaner with the code block;
        {
            System.out.println("Your score was less than 4000 and greater or equal than 1000");
        }
        else if (score < 1000)
        {
            System.out.println("Your score was less than 1000 thousand");
        }
        else
        {
            System.out.println("Got here");
        }
    }

}
