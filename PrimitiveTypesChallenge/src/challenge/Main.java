package challenge;

public class Main
{
    public static void main(String[] args)
    {
        byte byteVar = Byte.MAX_VALUE;
        short shortVar = Short.MAX_VALUE;
        int intVar = Integer.MAX_VALUE;
        long longVar = 50000L + (10L * (byteVar + shortVar + intVar)); // Don't need casting since Java does it for us.

        System.out.println("The total value is : " + longVar);

        short shortTotal = (short) (1000 + 10 * (byteVar + shortVar + intVar));
        System.out.println(shortTotal); // OverFlow
    }
}
