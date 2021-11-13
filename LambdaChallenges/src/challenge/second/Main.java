package challenge.second;

import java.util.function.Function;

public class Main
{
    public static void main(String[] args)
    {
        // Function using lambda version of the method
        // As it takes an argument and returns an argument it maps to a function from the Function package.
        Function<String, String> everySecondChar = source ->
        {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++)
            {
                if (i % 2 == 1)
                {
                    returnVal.append(source.charAt(i));
                }
            }

            return returnVal.toString();
        };

        // Lambda version of the method
//        (String source) ->
//        {
//            StringBuilder returnVal = new StringBuilder();
//            for (int i = 0; i < source.length(); i++)
//            {
//                if (i % 2 == 1)
//                {
//                    returnVal.append(source.charAt(i));
//                }
//            }
//
//            return returnVal.toString();
//        };

        System.out.println("Function using lambda version");
        System.out.println(everySecondChar.apply("This is the String for testing."));
        System.out.println("\nMethod version");
        System.out.println(everySecondChar("This is the String for testing."));
    }

    // Method
    public static String everySecondChar(String source)
    {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++)
        {
            if (i % 2 == 1)
            {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

}
