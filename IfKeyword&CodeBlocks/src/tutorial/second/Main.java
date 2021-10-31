package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        boolean gameOver = true;
        int score = 4000;
        int levelCompleted = 5;
        int bonus = 100;

        if (gameOver)
        { // The same as "if (gameOver == true)"
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        // int savedFinalScore = finalScore; Doesn't work since the variable "finalScore" was declared inside the if code block.
    }

}
