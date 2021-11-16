package challenge.tenth;

import challenge.Utilities;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

// Creating a new Class specifically for Parameterized Tests. If you try to run a parameterized class with normal tests
// these normal tests will be run multiple times since a new instance of the class is created for each test argument
// (passed in by the class constructor).
@RunWith(Parameterized.class)
public class UtilitiesTestParameterized
{
    private Utilities utilities;
    private String input;
    private String expected;

    public UtilitiesTestParameterized(String input, String expected)
    {
        this.input = input;
        this.expected = expected;
    }

    @org.junit.Before
    public void setUp()
    {
        utilities = new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions()
    {
        return Arrays.asList(
                new Object[][]{
                        {"ABCDEFF", "ABCDEF"},
                        {"AB88EFFG", "AB8EFG"},
                        {"112233445566", "123456"},
                        {"ZYZQQB", "ZYZQB"},
                        {"A", "A"}
                }
        );
    }

    @org.junit.Test
    public void removePairs()
    {
        assertEquals(expected, utilities.removePairs(input));
    }

}