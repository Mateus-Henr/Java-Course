package challenge.sixth;

import java.util.function.Supplier;

public class Main
{
    public static void main(String[] args)
    {
        // The Supplier interface doesn't accept any arguments, it just produces objects.
        Supplier<String> iLoveJava = () -> "I love Java";

        // Version with the return statement
        Supplier<String> iLoveJava1 = () ->
        {
            return "I love Java";
        };
    }

}
