package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5.00 / 3.00;
        System.out.println("MyIntValue = " + myIntValue);
        System.out.println("MyFloatValue = " + myFloatValue);
        System.out.println("MyDoubleValue = " + myDoubleValue);

        // Double is faster to process in modern computers, because computers have the chip level to deal with double numbers
        // faster than dealing with float. Another reason to use double is because the built-in Math library is prepared
        // to deal with double.
    }
}
