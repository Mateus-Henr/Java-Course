package challenge.ninth;

import challenge.Utilities;

import static org.junit.Assert.*;

public class UtilitiesTest
{
    private Utilities utilities;

    @org.junit.Before
    public void setUp()
    {
        utilities = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar()
    {
        assertArrayEquals("el".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 2));
    }

    @org.junit.Test
    public void everyNthChar_greaterLength()
    {
        assertArrayEquals("hello".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 6));
    }

    @org.junit.Test
    public void removePairs_oddLength()
    {
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
    }

    @org.junit.Test
    public void removePairs_evenLength()
    {
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
    }

    @org.junit.Test
    public void removePairs_noLength()
    {
        assertEquals("", utilities.removePairs(""));
    }

    @org.junit.Test
    public void removePairs_oneElement()
    {
        assertEquals("A", utilities.removePairs("A"));
    }

    @org.junit.Test
    public void removePairs_null()
    {
        assertNull("Did not get null, what was expected.", utilities.removePairs(null));
    }

    @org.junit.Test
    public void converter()
    {
        assertEquals(300, utilities.converter(10, 5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_divisionByZero()
    {
        utilities.converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddLength_oddLength()
    {
        assertNull(utilities.nullIfOddLength("hello"));
    }

    @org.junit.Test
    public void nullIfOddLength_evenLength()
    {
        assertNotNull(utilities.nullIfOddLength("hello!"));
    }

}