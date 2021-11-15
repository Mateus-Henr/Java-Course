package challenge.thirteenth;

public class Main
{
    public static void main(String[] args)
    {
        String challenge13 = "11111-1111";

        String regExp = "^\\d{5}-\\d{4}$";
        String regExp1 = "^[0-9]{5}-[0-9]{4}$";
        System.out.println(challenge13.matches(regExp));
        System.out.println(challenge13.matches(regExp1));

        // Depending on the scenario we could check the length of the user's string to identify which regular
        // expression should be used.
    }

}
