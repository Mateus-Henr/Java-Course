package tutorial.first;

public class Main
{
    // myInt = 15 + 12; (Statement)
    // Operators + - / *. Ex: +
    // Operands the numbers that the operator perform actions in. Ex: 15 and 12.
    // Expression is formed by combining variables, literals, method return values and operators.
    // Ex: 15 + 12 is the expression.

    // Another Example
    // double mySalary = hoursWorked * hourlyRate;
    // Operators: = and *
    // Operands: hoursWorked and hourlyRate
    // Expression: hoursWorked * hourlyRate
    // Statement: double mySalary = hoursWorked * hourlyRate;

    public static void main(String[] args)
    {
        // int result = 3; (Single operand)
        int result = 1 + 2; // 1 + 2 = 3 (Arithmetic)
        System.out.println("1 + 2 = " + result);

        int previousResult = result;
        System.out.println("previousResult = " + previousResult);
        result = result - 1; // 3 - 1 = 2
        System.out.println("3 - 1 = " + result);
        System.out.println("previousResult = " + previousResult); // Doesn't change even though result has changed.

        result = result * 10; // 2 * 10 = 20
        System.out.println("2 * 10 = " + result);

        result = result / 5; // 20 / 5 = 4
        System.out.println("20 / 5 = " + result);

        result = result % 3; // The remainder of (4 % 3) = 1
        System.out.println("4 % 3 = " + result);
    }
}
