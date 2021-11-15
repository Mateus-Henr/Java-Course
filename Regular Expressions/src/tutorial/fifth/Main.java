package tutorial.fifth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        // And, Or & Not operators
        // We've using "and" explicitly by using "abc", that means "a" and "b" and "c" (a letter followed by the other).
        // The "or" operator we used when using "[Hh]arry" (one or another). We can also use the "|" that means "or".
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));
        // When we used [^abc] we meant not when it's the first character within the square brackets. So it matches all
        // character except "a", "b" or "c".
        String tvTest = "tstvtkt";
        // When using "^" in square brackets we must match a character, therefore the character must exist (as we are
        // saying that the "t" must be followed by any character other than "v"), as shown below if we want to see how
        // many occurrences of "t" (considering the last "t"), so to fix it we can use the "!" ("not" character) in a
        // negative look ahead expression, since it doesn't consumer any characters (can match nothing).
        // Occurrences of "t" that aren't followed by the character "v".
//        String tNotVRegExp = "t[^v]";

        // Look Ahead Expressions
        // The question mark is part of the look-ahead syntax (they all start with parenthesis and a question mark).
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int count = 0;
        while (tNotVMatcher.find())
        {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // Positive Look Ahead expressions
        // If we want to use a positive look ahead expression we can use "=", in the below expressions we are saying
        // "Get to me all the matches that "t" is followed by "v", but don't include the "v" in the match.
        // t(?=v)

        // Sample of a Regular Expression to validate a US phone number
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        // Analyse of the expression
        // It must start matching,
        // We are assuming that the user is going to enter parenthesis, we are using "\" to escape the parenthesis,
        // since it's also a character literal (a command).
        // Using a quantifier between curly braces to specify how many numbers it must have.
        // "[ ]" is used to represent 1 blank.
        // The string must end with the entire pattern, that's why we are using a "$".

        String phone1 = "1234567890"; // Doesn't match
        String phone2 = "(123) 456-7890"; // Match
        String phone3 = "123 456-7890"; // Doesn't match
        String phone4 = "(123)456-7890"; // Doesn't match

        String phoneValidation = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$";

        // Using the "matches()" method since we will be matching the entire string.
        System.out.println("phone1 = " + phone1.matches(phoneValidation));
        System.out.println("phone2 = " + phone2.matches(phoneValidation));
        System.out.println("phone3 = " + phone3.matches(phoneValidation));
        System.out.println("phone4 = " + phone4.matches(phoneValidation));

        // Sample of a Regular Expression to validate visa numbers
        // ^4[0-9]{12}([0-9]{3})?$
        // The "?" is to match 0 or more occurrences of the group, since older cads don't have the last 3 numbers,
        // that's why we are using a group.
        String visa1 = "4444444444444"; // Should match
        String visa2 = "5444444444444"; // Shouldn't match
        String visa3 = "4444444444444444";  // Should match
        String visa4 = "4444";  // Shouldn't match

        System.out.println("visa1 = " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 = " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 = " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 = " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    }

}
