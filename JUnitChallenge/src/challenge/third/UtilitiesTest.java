package challenge.third;

import challenge.Utilities;

import static org.junit.Assert.*;

public class UtilitiesTest
{
    @org.junit.Test
    public void everyNthChar()
    {
        fail("This test has yet to be implemented.");
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