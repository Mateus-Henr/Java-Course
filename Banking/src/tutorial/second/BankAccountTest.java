package tutorial.second;

import static org.junit.Assert.*;

// Other JUnit assertion methods
// 1 - assertNotEquals() - When we don't want the value to be equal to a specific value.
// 2 - assertArrayEquals() - When we want to verify the value of an array, the arrays must be identical to pass. In
// this case, "assertEquals()" doesn't work since they try to compare if they are the same instance.
// 3 - assertNull & assertNotNull - When we want to check null or non-null values.
// 4 - assertSame & assertNotSame - When we want to check if two instances are the same instance, it compares the
// object references only (differently from the" assertEquals()" since it uses the "equals()" method for comparison).
// 5 - assertThat() - When we want to compare the actual value against a matcher (JUnit matcher class), this is more
// powerful because it can compare against a range of values.

public class BankAccountTest
{
    private BankAccount account;
    private static int count;

    // If we want to run a method only once before all the tests we can use the  "@org.junit.BeforeClass" annotation.
    // For the other scenarios, cleanup code, we can use the  "@org.junit.AfterClass" annotation.
    // And they must be static.
    // One example of it would be if we were using data from a database or file.
    @org.junit.BeforeClass
    public static void beforeClass()
    {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    // This annotation tells the JUnit framework to run this method every time we run a test.
    @org.junit.Before
    public void setup()
    {
        // Creating a new Bank account instance for the tests in just one place.
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @org.junit.Test
    public void deposit()
    {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch()
    {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    // In scenarios that we expect an exception to be thrown we have to make a change to the annotation, as shown below.
    // And if we are expecting an exception and the exception really happens, the test will pass.
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch()
    {
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException");
        // As we are expecting an exception to be thrown we can remove the "assertEquals" method.
//        assertEquals(400.00, balance, 0);
    }

    // When working with earlier version of JUnit the above method code would be:
    @org.junit.Test
    public void withdraw_notBranchOldJUnit()
    {
        try
        {
            account.withdraw(600.00, false);
            // The fail is here to make sure that the exception is going to be thrown.
            fail("Should have thrown an IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    @org.junit.Test
    public void getBalance_deposit()
    {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw()
    {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true()
    {
        assertTrue("The account is NOT a checking account.", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass()
    {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After // This will execute after every test, similarly to the "@Before" annotation.
    public void teardown()
    {
        System.out.println("Count = " + count++);
    }

}