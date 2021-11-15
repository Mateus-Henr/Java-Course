package challenge.fourth;

public class Main
{
    public static void main(String[] args)
    {
        String challenge4 = "Replace all blanks with underscores.";

        System.out.println(challenge4.replaceAll(" ", "_"));
        // Using the character class "\\s" will replace ALL the whitespaces not just blanks.
        System.out.println(challenge4.replaceAll("\\s", "_"));
    }
}
