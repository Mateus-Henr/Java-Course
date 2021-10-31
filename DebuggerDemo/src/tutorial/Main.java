package tutorial;


// When debugging a socket is opened because the debugger attaches to the app using that socket.
public class Main
{
    public static void main(String[] args)
    {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 10)
        {
            utils.addChar(sb, 'a');
        }

        System.out.println(sb);
    }
}
