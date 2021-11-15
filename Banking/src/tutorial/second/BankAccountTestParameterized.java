package tutorial.second;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// Parameterized Tests
// They are used to avoiding code repetition when testing multiple scenarios of a method for example.
// When using it you have to create a class that's not a normal test class and the class annotation below has to be used
// to represent it.
@RunWith(Parameterized.class)
public class BankAccountTestParameterized
{
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected)
    {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup()
    {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    // This method is used to test several cases scenarios in the same method.
    @Parameterized.Parameters
    public static Collection<Object[]> testConditions()
    {
        // Each row below is a set of parameters that we want to test followed by the expected value.
        // When we run a Parameterized Test, JUnit will create a new instance of the BankAccountTestParameterized for
        // each set of test data, and it'll use the class constructor to set instance variables to the values we've
        // specified. And that explains the need of a new class for running the tests.
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }

    @org.junit.Test
    public void deposit()
    {
        // USing the instances variables for the Parameterized test.
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01); // Dealing with the double precision
    }

}
