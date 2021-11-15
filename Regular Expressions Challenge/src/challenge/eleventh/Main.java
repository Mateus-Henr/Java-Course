package challenge.eleventh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        String challenge11 = "{0, 2}, {0, 5}, {1, 3},{2, 4}";

        // Taking the greedy off the "+" (plus) quantifier, in other words making it lazy to only match one match.
        String regExp = "\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge11);

        while (matcher.find())
        {
            System.out.println("Occurrence = " + matcher.group(1));
        }

        System.out.println("\nChallenge 11a");
        String challenge11a = "{0, 2}, {0, 5}, {1, 3},{2, 4} {x, y}, {6, 34}, {11, 12}";

        // As we are using "\\d" for numbers here, we don't have to use "?", since the match will be limited by the "}",
        // that's not a number.
        String regExp1 = "\\{(\\d+, \\d+)\\}";
        Pattern pattern1 = Pattern.compile(regExp1);
        Matcher matcher1 = pattern1.matcher(challenge11a);

        while (matcher1.find())
        {
            System.out.println("Occurrence = " + matcher1.group(1));
        }
    }

}
