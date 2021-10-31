package tutorial.challenge;

public class Main
{
    public static void main(String[] args)
    {
        boolean gameOver = true;
        int score = 4000;
        int levelCompleted = 5;
        int bonus = 100;

        if (gameOver)
        {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000; // Additional bonus
            System.out.println("Your first final score was " + finalScore);
        }

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if (gameOver)
        {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your second final score was " + finalScore);
        }
    }

}
