package challenge.ninth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";

        String regExp = "[a-zA-Z]+\\.(\\d+)(\t|\n$)";
        // String regExp = "[a-zA-Z]+\\.(\\d+)\\s"; // Tim's version
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge9);

        while (matcher.find())
        {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }

}
