package challenge.thirteenth;

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

        // The following code will print nothing since there isn't a terminal operation for the code to be executed.
        // Stream chains are evaluated lazily. Nothing happens until a terminal operation is added to the chain. At
        // that point, the chain is executed.
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo);
    }
}
