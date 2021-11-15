package challenge.sixth;

public class Main
{
    public static void main(String[] args)
    {
        String challenge5 = "aaabccccccccdddefffg";

        String regExp = "^aaabccccccccdddefffg$";
        String regExp1 = "^a{3}bc{8}d{3}ef{3}g$"; // Tim's solution
        System.out.println(challenge5.matches(regExp));
        System.out.println(challenge5.matches(regExp1));
        // Verifying the regExp using "replaceAll()"
        System.out.println(challenge5.replaceAll(regExp1, "REPLACED"));
    }
}
