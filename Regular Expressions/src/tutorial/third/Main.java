package tutorial.third;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        String thirdAlphaNumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDeee", "YYY"));

        // Quantifier
        // Specify how often an element in a regular expression can occur. We can use curly braces to specify the
        // number of the preceding character that must occur in order for that to be a match.
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe{3}", "YYY"));
        // We use "+" (plus quantifier) when we don't care about the number of repetitions of the preceding character
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe+", "YYY"));
        // We use "*" (astrix quantifier) to match the preceding character, whether it has the character or not
        // It could be used when you need to verify a part
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe*", "YYY"));
        // Looking for a specific range of character
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe{2,5}", "YYY"));
        // In the code below, we want to see at least one "h", followed by 0 or more "i"s and followed by a "j"
        System.out.println(thirdAlphaNumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>MyHeading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        // Combining "." with the "*", the dot will match every character and the star will matcher 0 or more of the
        // character. In other words we are saying that it could have anything before as well as after the "<h2>".
        String h2Pattern = ".*<h2>.*";
        // Pattern class
        // We can use this class to manipulate strings using regular expressions, some APIs work with it, and we use
        // the "compile()" method to compile a regular expression into a Pattern.
        // Generally used when we want to work with methods in the Matcher class.
        // More about it at: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        // Ignoring case
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        // Matcher
        // It works with classes that implement the charSequence interface, and we can use Strings, StringBuilder, etc.
        // It's used when we want to find multiple occurrences of a pattern or when we want to use the same pattern
        // with multiple sequences.
        // This "matches()" method also wants to match the string as a whole just like the "String.matches()" method.
        // More about it at: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches()); // Check whether the pattern matches
    }

}
