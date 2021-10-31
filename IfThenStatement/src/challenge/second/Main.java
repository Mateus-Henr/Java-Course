package challenge.second;

public class Main
{
    public static void main(String[] args)
    {
        double myDouble = 20.00d;
        double mySecondDouble = 80.00d;

        double doublesTogether = 100.00d * (myDouble + mySecondDouble);
        System.out.println("doublesTogether = " + doublesTogether);

        double doubleRemainder = doublesTogether % 40.00d;
        System.out.println("doubleRemainder = " + doubleRemainder);

        boolean hasRemainder = (doubleRemainder == 0d);
        System.out.println("doubleBoolean = " + hasRemainder);

        if (!hasRemainder)
        {
            System.out.println("Got some remainder!");
        }
    }
}
