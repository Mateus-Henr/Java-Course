package challenge.fifth;

public class Main
{
    public static void main(String[] args)
    {
        String challenge5 = "aaabccccccccdddefffg";

        String regExp = "^aaabccccccccdddefffg$";
        String regExp1 = "\\D{20}";
        String regExp3 = "[a-g]+";

        System.out.println(challenge5.matches(regExp));
        System.out.println(challenge5.matches(regExp1));
        System.out.println(challenge5.matches(regExp3));
    }

}
