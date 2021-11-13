package challenge.seventh;

import java.util.function.Supplier;

public class Main
{
    public static void main(String[] args)
    {
        Supplier<String> iLoveJava = () -> "I love Java";
        System.out.println(iLoveJava.get()); // "get()" for getting the value of the Supplier.
    }

}
