package challenge.eleventh;

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

        System.out.println("Stream");
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach(System.out::println);

        // Even though we did a lot of operations through a stream, the actual list hasn't been modified.
        System.out.println("\nCurrent List");
        topNames2015.forEach(System.out::println);
    }

}
