package challenge.third;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

        String regExp = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge1);
        // We could have used the same "matcher" object instead of creating a new one and if we did so we wouldn't need
        // to reset the matcher since they would be using different instances.
        Matcher matcher1 = pattern.matcher(challenge2);

        System.out.println(matcher.matches());
        System.out.println(matcher1.matches());
    }

}
