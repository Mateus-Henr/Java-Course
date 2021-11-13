package challenge.third;

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

        System.out.println("Executing the function");
        System.out.println(everySecondChar.apply("1234567890"));
    }

}
