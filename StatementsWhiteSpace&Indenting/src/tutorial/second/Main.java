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

        // PostFix
        // When using increment or decrement operations in a "println" it'll be modified after the print has already
        // happened. It was a PostFix because was done after the output happened.
        System.out.println("Lives remaining " + playerLives--);
        System.out.println("Lives remaining " + playerLives);

        // Prefix
        // When the command happens before the output.
        System.out.println("Lives = " + --playerLives);
        System.out.println("Lives = " + ++playerLives);

        // As statements the follow the same rule.
        playerLives++;
        System.out.println("Lives remaining " + playerLives);
        playerLives--;
        System.out.println("Lives remaining " + playerLives);
        ++playerLives;
        System.out.println("Lives remaining " + playerLives);
        --playerLives;
        System.out.println("Lives remaining " + playerLives);


        if (calculatedScore++ > 59)
        {
            System.out.println("I calculate your score as being more than 59!");
        }

        if (++calculatedScore > 59)
        {
            System.out.println("I calculate your score as being more than 59!");
        }

        // Control flow statement -> Conditions, looping and branching statements (break, continue, etc).
    }

}
