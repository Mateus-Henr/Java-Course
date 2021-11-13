package challenge.ninth;

import java.util.ArrayList;
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

        System.out.println("My version");
        topNames2015.sort((o1, o2) -> o1.compareToIgnoreCase(o2));
        topNames2015.forEach(s -> System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1)));

        // Tim's version
        System.out.println("\nTim's version");
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name -> firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort((s1, s2) -> s2.compareTo(s2));
        firstUpperCaseList.forEach(s -> System.out.println(s));
    }

}
