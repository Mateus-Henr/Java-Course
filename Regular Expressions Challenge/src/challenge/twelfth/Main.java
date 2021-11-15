package challenge.twelfth;

public class Main
{
    public static void main(String[] args)
    {
        String challenge12 = "11111";

        // DON'T FORGET THE CARROT "^" AND THE DOLLAR SIGN "$".
        String regExp = "^\\d{5}$";
        String regExp1 = "^[0-9]{5}$";
        System.out.println(challenge12.matches(regExp));
        System.out.println(challenge12.matches(regExp1));
    }

}
