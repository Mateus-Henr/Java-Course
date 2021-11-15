package challenge.tenth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";

        String regExp = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge10);

        while (matcher.find())
        {
            // Using "start()" and "end()" based on the group location, since we are interested in them.
            System.out.println("Occurrence: " + matcher.group(1) + " from " + matcher.start(1) + " to " +
                    (matcher.end(1) - 1));
        }
    }

}
