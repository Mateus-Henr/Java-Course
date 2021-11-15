package challenge.second;

public class Main
{
    public static void main(String[] args)
    {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

        // Group can also be used when we want to use the "|" operator.
        String regExp = "I want a (ball|bike)\\.";
        // String regExp = "I want a \\w+."; // First Tim's solution
        // "\\w" matches a-z upper or lowercase, 0 to 9 and the underscore.
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));
    }

}
