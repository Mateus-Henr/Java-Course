package tutorial.first;

public class StringUtilities
{
    // By setting a breakpoint, when the Java Runtime gets to that line of code the app will suspend.
    // When an app stops at a breakpoint the line of code where the breakpoint is HAS NOT BEEN EXECUTED YETs.
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c)
    {
        // Due to the fact that we are using "this" here, there's a bug in the code since it'll be accessing the global
        // variable instead of the variable passed in as a parameter.
//        this.sBuilder.append(c); // If we place a breakpoint here THIS LINE WILL NOT EXECUTE WHEN ON THE BREAKPOINT
        sBuilder.append(c);
        charsAdded++;
    }

}
