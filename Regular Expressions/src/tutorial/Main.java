package tutorial;

public class Main
{
    // Regular expressions
    // They are ways for describing a String or a pattern. Some methods in the String class accept a regular expression
    // as a parameter, for example the "matches()" and "split()" methods.
    // They are often used to search strings for a specific pattern or to see if an input matches a pattern.
    // Example checking if an email address is valid by its looks.
    public static void main(String[] args)
    {
        // The simplest form of a regular expression is a string literal.
        String string = "I am a String. Yes, I am.";
        System.out.println(string);

        // The "replaceAll()" method accepts a regular expression that describes a pattern that we want to replace as
        // the first parameter, the second parameter is the replacement string.
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        // Character Classes
        // Represents a set or a class of characters.
        // The character class "." matches all the characters. They are "wild cards".
        String alphaNumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));

        // Boundary Matches
        // Looks for boundaries, such as the beginning or end of a string or word.
        // The carrot boundary matcher "^" is followed by a pattern. When using it the pattern must match the beginning
        // of the string.
        // The length of the replacement string doesn't have to match the length of the string that's going to be
        // replaced.
        System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));

        // Even though the pattern is found again in the string, because we are using "^" it won't be altered again.
        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        // "matches()" method
        // When using this method the string as a whole must match a regular expression.
        // For verifying a given pattern it could be useful.
        System.out.println(alphaNumeric.matches("^hello"));
        System.out.println(alphaNumeric.matches("^abcDeee"));
        System.out.println(alphaNumeric.matches("abcDeeeF12Ghhiiiijkl99z"));

        // The "$" boundary matcher is also preceded by a pattern, and it'll match strings that end with that pattern.
        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "THE END"));

        // To match a specific letter or a set of letters, we put those letter within square brackets.
        // It doesn't look for the pattern, it looks for each individual letter.
        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));
        System.out.println(alphaNumeric.replaceAll("[aei]", "I replaced a letter here."));
        // Replacing letters if followed by a pattern, in the case below it's a case of permutation, so it looks for
        // 3! * 2! = 12 possibilities.
        System.out.println(alphaNumeric.replaceAll("[aei][Fg]", "X"));
    }

    // IntelliJ has got a feature that we can test regular expressions, it can be accessed by placing yhe cursor
    // over a "regex" and clicking on "Show Context Actions" parameter and going to "CheckRegExp".

}
