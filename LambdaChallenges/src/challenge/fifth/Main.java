package challenge.fifth;

import java.util.function.Function;

public class Main
{
    public static void main(String[] args)
    {
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

        System.out.println("Method using a function as parameter");
        System.out.println(everySecondChar(everySecondChar, "1234567890"));
    }

    public static String everySecondChar(Function<String, String> function, String source)
    {
        return function.apply(source);
    }

}
