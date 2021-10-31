package tutorial.staticMeth;

// Static Methods Example
public class Calculator
{
    public static void printSum(int a, int b)
    {
        System.out.println("sum=" + (a + b));
    }

}

class Main2
{
    public static void main(String[] args)
    {
        Calculator.printSum(5, 10);
        printHello(); // Shorter from of Main.printHello();
    }

    public static void printHello()
    {
        System.out.println("Hello");
    }
}
