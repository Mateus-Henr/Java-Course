package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10)
        {
            utils.addChar(sb, 'a');
        }

        System.out.println(sb);

        String str = "abcdefg";
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }

    // We can set value for variables on the fly. It's usually used when we want to test the rest of the code based on
    // a specific value. To do so in the debugger panel by clicking with the right-button on the desired variable you
    // can select "Set Value..." to set a value for the variable. And the new value will start to be used by the app as
    // it runs.

    // If we wanted to use third party libraries we would have to add it to the "Libraries" part of the project as
    // ".jar" files, but as we are using the debugger we would need to get the binary file that would be needed to add
    // as "Classes" and the source code that would be needed to add as "Sources". However, sometimes even though you
    // have the source code and the binary file, the source code doesn't have debugger information, making it impossible
    // to debug. If you don't have the source code then usually the debugger can show us the method declarations
    // because it configures those out from the Java binary files, but we won't be able to see individual lines of code.
}