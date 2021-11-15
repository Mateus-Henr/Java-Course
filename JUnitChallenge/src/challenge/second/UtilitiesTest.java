package challenge.second;

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
    public void removePairs_first()
    {
        Utilities utilities = new Utilities();
        String source = "AABCDDEFF";
        String removedPairs = utilities.removePairs(source);
        assertEquals("ABCDEF", removedPairs);
    }

    @org.junit.Test
    public void removePairs_second()
    {
        Utilities utilities = new Utilities();
        String source = "ABCCABDEEF";
        String removedPairs = utilities.removePairs(source);
        assertEquals("ABCABDEF", removedPairs);
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