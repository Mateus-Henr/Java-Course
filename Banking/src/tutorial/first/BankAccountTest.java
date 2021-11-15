package tutorial.first;

import static org.junit.Assert.*;

// It's conventional for the unit test classes to have the same name as the class that it will test (plus "Test").
// A unit is just one method, so a unit test will typically test one method.
// When we use JUnit we test the output of a method against an assertion that we've made about the expected output.
// And if a test pass is because any assertions in the test are valid.
// All methods must be annotated, public and void.
public class BankAccountTest
{
    @org.junit.Test // This annotation tells the JUnit framework that this is a test method.
    public void deposit()
    {
//        fail("This test has yet to be implemented."); // Reminder (good practise)
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);

        // When comparing doubles we have to use the third parameter that allows some leeway between the expected value
        // and the actual value.
        // Even though we can define multiple asserts in one test method, it's not a good practise to do so.
        assertEquals(1200.00, balance, 0);
    }

    // Test method should be SELF-CONTAINED, therefore what happens in one test method shouldn't depend on what
    // happened in another test method (THEY MUST BE INDEPENDENT).
    // WE CANNOT HAVE INSTANCE VARIABLES in our test class, when writing tests you need to see whether the test can run
    // and pass on its own, and it always has to be YES.
    @org.junit.Test
    public void withdraw()
    {
        fail("This test has yet to be implemented.");
    }

    // Stubs = Empty methods (Make sure to not have them, since tests will pass if the method is a stub).
    @org.junit.Test
    public void getBalance_deposit()
    {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    // Another good practise -> Test method names should give an indication of what they're testing.
    // In this case we modified the name to represent the balance after calling a specific method.
    @org.junit.Test
    public void getBalance_withdraw()
    {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    // In real word application we wouldn't be creating our own methods, we would be associating them with the methods
    // that we've made on the "main" class.
    @org.junit.Test
    public void dummyTest()
    {
        // When using the "assertEquals" the first parameter is the expected value and the second parameter is the value
        // actual value.
        assertEquals(20, 20);
    }

    @org.junit.Test
    public void isChecking_true()
    {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        // For checking boolean values it's better to use "assertTrue"
//        assertEquals(true, account.isChecking());
        // When there are multiple test suites messages are very helpful.
        assertTrue("The account is NOT a checking account.", account.isChecking());
    }

}

// Installing JUnit
// Even after adding the library the JUnit references might be unresolved, that's because when we clicked the "Fix"
// button (when creating the test class) and IntelliJ added the library to the classpath, it set the usage of the
// library to testing which means that the library will only be included when we run tests, but not when we compile
// them. To fix it we go to "Project Structure > Modules > JUnit" and on the dropdown select "Compile".

// Another way of doing it is to not click on "Fix" when setting up the JUnit class, just create this and then press
// "Alt" + "Enter" on the red part on the JUnit annotation and click on "Add JUnit to the classpath" and then select
// to use IntelliJ version.