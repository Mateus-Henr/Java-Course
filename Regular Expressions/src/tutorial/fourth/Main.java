package tutorial.fourth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        StringBuilder htmlText = new StringBuilder("<h1>MyHeading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        // Changing the pattern since we want specific matches inside a string, not just a match in the entire string.
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        // Resetting the matcher to use it again.
        matcher.reset();
        // Finding where the occurrences are and if there are any
        // "start()" method can be used to get the start of the occurrence, it gets the index of the first character
        // in the match, and the "end()" method gets the index of the character right after the last character in the
        // match.
        // "find()" method (looks for occurrences of a pattern)
        int count = 0;
        while (matcher.find())
        {
            count++;
            // Printing occurrences using the ".*<h2>.*" isn't specific enough, using it this way we are matching the
            // entire string (since we use such a broad expression, there's just one occurrence), knowing that, it's
            // giving us the start of the entire string and the end of it.
            // Therefore, we need to use "<h2>" as the regular expression, since we are not matching the entire string
            // anymore.
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }
        // Matchers can only be used once, they have an internal state that is updated whenever we use it.
        // So the state is being updated when we are using "matcher.matches()" and because of that the "find()" method
        // doesn't find anything.

        // Using a group in a regular expression
        // When working with groups we access them using the "group()" method in the matcher class
        // The first version of it takes an int parameter that is the group number. The entire character sequence is
        // group 0, so if we want to access a specific group we start counting from the number 1.
        // When using groups we have to surround the regular expression with parenthesis.

        // Greedy quantifiers vs Reluctant/Lazy quantifiers
        // The "*" is a greedy quantifier, because it doesn't stop at the first match it keeps going to see if it can
        // find more.
        // A lazy quantifier does just the minimum amount of work, therefore it gets just one match. The "?" is a lazy
        // quantifier and can be used to stop as soon as we get to the match (it doesn't keep going).

        // By adding the "?" after the "*" we transform the "*" in a lazy quantifier.
        // The way that we are using now, even though if there wasn't anything between the "h2" tags, it would match.
        // To avoid empty tags we could use the "+" instead of the "*", since the "+" quantifier only accepts one
        // occurrence or more.
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset(); // Resetting it to reuse the matcher.

        while (groupMatcher.find())
        {
            // For each occurrence we are calling the group 1. As the group 0 is the entire character sequence that's
            // why we are using 1.
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        // By using it this way, we are assigning three groups, therefore we will find "<h2>" in the group 1, the text
        // after the first "<h2>" and before "</h2>" will be the group 2 and the third group will be the "h2" enclosing
        // tag.
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find())
        {
            // Getting only the content of the "<h2>" tag.
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        // You can also use methods like "replaceFirst" to replace just specific parts of the string.
        // More at: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html
    }

}
