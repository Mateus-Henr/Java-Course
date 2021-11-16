package challenge.fifth;

import challenge.Utilities;

import static org.junit.Assert.*;

public class UtilitiesTest
{
    @org.junit.Test
    public void everyNthChar()
    {
        Utilities utilities = new Utilities();
        assertArrayEquals("el".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 2));
        // AssertEquals in this case would be wrong because it would be checking if the values are the same instance.
    }

    @org.junit.Test
    public void everyNthChar_greaterLength()
    {
        Utilities utilities = new Utilities();
        assertArrayEquals("hello".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 6));
    }

    @org.junit.Test
    public void removePairs_oddLength()
    {
        Utilities utilities = new Utilities();
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
    }

    @org.junit.Test
    public void removePairs_evenLength()
    {
        Utilities utilities = new Utilities();
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
    }

    @org.junit.Test
    public void removePairs_noLength()
    {
        Utilities utilities = new Utilities();
        assertEquals("", utilities.removePairs(""));
    }

    @org.junit.Test
    public void removePairs_oneElement()
    {
        Utilities utilities = new Utilities();
        assertEquals("A", utilities.removePairs("A"));
    }

    @org.junit.Test
    public void removePairs_null()
    {
        Utilities utilities = new Utilities();
        assertNull("Did not get null, what was expected", utilities.removePairs(null));
    }

    @org.junit.Test
    public void converter()
    {
        fail("This test has yet to be implemented.");
    }

    @org.junit.Test
    public void nullIfOddLength()
    {
        fail("This test has yet to be implemented.");
    }

}