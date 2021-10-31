package challenge.first;

public class Main
{
    public static void main(String[] args)
    {
        int playerScore = calculateHighScorePosition(1500);
        displayHighScorePosition("Mateus", playerScore);
        // 600
        playerScore = calculateHighScorePosition(900);
        displayHighScorePosition("Leo", playerScore);
        // 500
        playerScore = calculateHighScorePosition(400);
        displayHighScorePosition("Tim", playerScore);
        // 350
        playerScore = calculateHighScorePosition(50);
        displayHighScorePosition("Lucas", playerScore);
    }

    private static void displayHighScorePosition(String playerName, int position)
    {
        System.out.println("The player named as " + playerName + " managed to get into position " + position + " on the high score table.");
    }

    private static int calculateHighScorePosition(int playerScore)
    {
        int position = 4; // Else value, before position "return" was being used. Just one return make the code cleaner.

        if (playerScore >= 1000)
        {
            position = 1;
        }
        else if (playerScore >= 500 && playerScore < 1000) // Kept the error.
        {
            position = 2;
        }
        else if (playerScore > 100 && playerScore < 500)
        {
            position = 3;
        }

        return position;
    }

}
