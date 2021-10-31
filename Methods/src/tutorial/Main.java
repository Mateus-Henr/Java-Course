package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        boolean gameOver = true;
        int score = 4000;
        int levelCompleted = 5;
        int bonus = 100; // You can also comment these variables and pass the hard-coded values to the arguments.

        if (gameOver)
        {
            System.out.println("Your first final score was " + calculateFinalScore(score, levelCompleted, bonus));
        }

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if (gameOver)
        {
            System.out.println("Your second final score was " + calculateFinalScore(score, levelCompleted, bonus));
        }
    }

    private static int calculateFinalScore(int score, int levelCompleted, int bonus) // Avoid duplication in the future because here you can manage possible
    {                                                                                // additional bonus and stuff.
        // int finalScore = score + (levelCompleted * bonus);
        return score + (levelCompleted * bonus);
    }

}
