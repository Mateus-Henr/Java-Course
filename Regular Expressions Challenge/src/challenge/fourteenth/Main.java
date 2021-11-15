package challenge.fourteenth;

public class Main
{
    public static void main(String[] args)
    {
        String challenge12 = "11111";
        String challenge13 = "11111-1111";

        // We can use the "?" after the group to consider the whole group and try to match it for 0 or 1 occurrences,
        // 1 because the "?" is a lazy quantifier.
        String regExp = "^\\d{5}(-\\d{4})?$";
        String regExp1 = "^[0-9]{5}(-[0-9]{4})?$";
        System.out.println(challenge12.matches(regExp));
        System.out.println(challenge12.matches(regExp1));
        System.out.println(challenge13.matches(regExp));
        System.out.println(challenge13.matches(regExp1));


        // Normally we can find regular expressions on the web, however we need to be careful because there are lots
        // of variations and some that are incomplete (example below of a Canadian zip code).
        // ^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$
        // It's wrong because Canadian post code cannot contain specific letter and generally don't contain a dash.
    }
}
