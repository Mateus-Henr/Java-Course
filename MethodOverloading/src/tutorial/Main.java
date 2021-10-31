package tutorial;

public class Main
{
    public static void main(String[] args)
    {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore + ".");

        calculateScore(1000);

        calculateScore();
    }

    public static int calculateScore(String playerName, int score)
    {
        System.out.println("Player " + playerName + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore(int score)
    {
        System.out.println("Unnamed player scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore()
    {
        System.out.println("No player name, no player score.");
        return 0;
    }

    // public static void calculateScore()
    // {
    //    System.out.println("No player name, no player score.");
    /// }
    // Changing the return type doesn't make a method unique. A method signature is defined by its name + its parameters.
}
