package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        String newAlphaNumeric = "abcDeeeF12Ghhiiiijkl99z";

        // Replacing all the letter, but specific ones
        // When we use the carrot ("^") as the first character inside square brackets, it's actually a character class,
        // not a boundary matcher. When using it like this it negates the pattern inside it.
        // So in the code below it'll match all occurrences but the ones inside the square brackets.
        System.out.println(newAlphaNumeric.replaceAll("[^ej]", "X"));
        // Regular expressions are case sensitive
        System.out.println(newAlphaNumeric.replaceAll("[abcdef345678]", "X"));
        // We can use the dash character ("-") to specify a range, as shown below.
        System.out.println(newAlphaNumeric.replaceAll("[a-f3-8]", "X"));
        // Matching both cases (lower and upper)
        System.out.println(newAlphaNumeric.replaceAll("[a-fA-F3-8]", "X"));
        // Turning off case sensitiveness, if the string is unicode we would use "(?iu)"
        System.out.println(newAlphaNumeric.replaceAll("(?i)[a-f3-8]", "X"));
        // Replacing all the numbers in the string
        System.out.println(newAlphaNumeric.replaceAll("[0-9]", "X"));
        // We can use "\\d" as a shortcut to replace all digits
        System.out.println(newAlphaNumeric.replaceAll("\\d", "X"));
        // We can use "\\D" as a shortcut to replace all non-digit values
        System.out.println(newAlphaNumeric.replaceAll("\\D", "X"));

        String hasWhitespace = "I have blanks and\ta tab, and also a new line\n";
        System.out.println(hasWhitespace);
        // Removing all whitespaces from the string using a regular expression by using "\\s"
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        // Replacing specific character
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        //Replacing all non-whitespace characters by using "\\S"
        // In the example below it will only remain tab, spaces and newline characters.
        System.out.println(hasWhitespace.replaceAll("\\S", ""));
        // "\\w" matches a-z in lowercase and in uppercase, 0 to 9 and  the underscore ("_")
        System.out.println(newAlphaNumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));
        // By using "\\W" it'll match everything but a-z (upper or lower), 0 to 9 and underscore
        System.out.println(hasWhitespace.replaceAll("\\W", "X"));
        // The "\\b" matches word boundaries, it assumes that words are separated by whitespaces
        // When using it, each word will be surrounded by the replacement string.
        // Could be very handy when working with tags (html or latex for example).
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));
    }

}
