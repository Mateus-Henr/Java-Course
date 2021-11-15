package challenge.eighth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        String challenge8 = "abcd.135uvqz.7tzik.999";

        // Groups are used to get specific chunks of a pattern.
        String regExp = "[a-zA-Z]+\\.(\\d+)";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge8);

        while (matcher.find())
        {
            System.out.println("Occurrence: " + matcher.group(1));
            // Remember: "group(0)" is the entire string.
        }
    }

}
