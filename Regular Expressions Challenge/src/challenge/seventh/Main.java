package challenge.seventh;

public class Main
{
    public static void main(String[] args)
    {
        String challenge7 = "abcd.135";

        // Remember that "\\D" or "\\d" or "[a-z]" alone just count for one character.
        String regExp = "^\\D+\\.\\d+$";
        String regExp1 = "^[a-zA-Z]+\\.[0-9]+$";
        System.out.println(challenge7.matches(regExp));
        System.out.println(challenge7.matches(regExp1));
    }

}
