package challenge;

public class Utilities
{
    // Returns a char array containing every nth char. When sourceArray.length < n, returns sourceArray.
    public char[] everyNthChar(char[] sourceArray, int n)
    {
        if (sourceArray == null || sourceArray.length < n)
        {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n)
        {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    // It removes pairs of the same character that are next to each other, by removing one occurrence of the character.
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF" (the two B's aren't next to each other, so they aren't removed.)
    public String removePairs(String source)
    {
        // If length is less than 2, there won't be any pairs
        if (source.length() < 2)
        {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length - 1; i++)
        {
            System.out.println(string[i]);
            if (string[i] != string[i + 1])
            {
                sb.append(string[i]);
            }
        }

        // The last character will always be safe, because in the comparison between a position and the next position,
        // if they are equals the character won't be added, so we need to add it (this occurs in an array with an even
        // length), if the array has an odd length the last character will always be safe.
        sb.append(string[string.length - 1]);
        System.out.println(string[string.length - 1]); // Just to match the "println" in the for loop.

        return sb.toString();
    }

    // Performs a conversion based on some internal business rule.
    public int converter(int a, int b)
    {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source)
    {
        if (source.length() % 2 == 0)
        {
            return source;
        }

        return null;
    }

}
