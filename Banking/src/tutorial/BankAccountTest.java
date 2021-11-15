package tutorial;

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
        fail("This test has yet to be implemented."); // Reminder (good practise)
    }

    @org.junit.Test
    public void withdraw()
    {
        fail("This test has yet to be implemented.");
    }

    // Stubs = Empty methods (Make sure to not have them, since tests will pass if the method is a stub.
    @org.junit.Test
    public void getBalance()
    {
        fail("This test has yet to be implemented.");
    }

    // In real word application we wouldn't be creating our own methods, we would be associating them with the methods
    // that we've made on the "main" class.
    @org.junit.Test
    public void dummyTest()
    {
        // When using the "assertEquals" the first parameter is the expected value and the second parameter is the value
        // actual value.
        assertEquals(20, 21);
    }
}

// Even after adding the library the JUnit references might be unresolved, that's because when we clicked the "Fix"
// button (when creating the test class) and IntelliJ added the library to the classpath, it set the usage of the
// library to testing which means that the library will only be included when we run tests, but not when we compile
// them. To fix it we go to "Project Structure > Modules > JUnit" and on the dropdown select "Compile".

// Another way of doing it is to not click on "Fix" when setting up the JUnit class, just create this and then press
// "Alt" + "Enter" on the red part on the JUnit annotation and click on "Add JUnit to the classpath" and then select
// to use IntelliJ version.