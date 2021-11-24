package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        // A statement forms a complete unit of execution.
        // The three statements are:
        // Declaration statement -> Declaring variables.
        int finalScore = 50;
        int playersHighScore;
        int playerLives = 3;

        // Storing the value of the variable "finalScore" that's equal to 60 into the "calculatedScore" variable.
        int calculatedScore = finalScore = 60;
        System.out.println("Calculated Score " + calculatedScore);

        // Expression statement -> Assignment expressions, "++" and "--", method calls and object creation.
        finalScore = 60;
        playerLives--;
        System.out.println("Lives remaining " + playerLives--);

        // Control flow statement -> Conditions, looping and branching statements (break, continue, etc).
    }

}
