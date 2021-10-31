package tutorial;

public class StringUtilities
{
    // When an app stops at a breakpoint the line of code where the breakpoint is hasn't been executed yet.
    private StringBuilder sBuilder = new StringBuilder();
    private int charAdded = 0;

    public void addChar(StringBuilder sBuilder, char c)
    {
        this.sBuilder.append(c);
        charAdded++;
    }

}
