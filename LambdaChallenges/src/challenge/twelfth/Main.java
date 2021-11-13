package challenge.twelfth;

import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A")) // charAt(0) == 'A' could also be used.
                .count();
        System.out.println("Number of names that start with A = " + namesBeginningWithA);
    }

}
