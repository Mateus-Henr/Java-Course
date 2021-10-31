package tutorial.second;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// The Collections framework has always provided a number of so-called "bulk operations" as part of its API.
// These include methods that operate on entire collections, such as containsAll, addAll, removeAll, etc.
public class SetMain
{
    public static void main(String[] args)
    {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++)
        {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");

        Set<Integer> union = new HashSet<>(squares); // Passing the "squares" to the union's constructor.
        union.addAll(cubes);

        System.out.println("Union contains " + union.size() + " elements."); // 196 elements. Remember sets support unique values.

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);

        System.out.println("Intersection contains " + intersection.size() + " elements.");
        for (int i : intersection)
        {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        // The Arrays class is some sort of bridge between the Array and the Collection APIs.

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] array = sentence.split(" ");
        words.addAll(Arrays.asList(array));

        for (String s : words)
        {
            System.out.println(s);
        }

        // Symmetric difference = elements that appear in both sets.
        // Asymmetric difference = elements that don't appear in both sets. (There's no specific method for it)

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown ", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);


        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if (nature.containsAll(divine))
        {
            System.out.println("Divine is a subset of nature.");
        }

        if (nature.containsAll(intersectionTest))
        {
            System.out.println("Intersection is a subset of nature.");
        }

        if (divine.containsAll(intersectionTest))
        {
            System.out.println("Intersection is a subset of divine.");
        }

    }

    private static void printSet(Set<String> setToShow)
    {
        System.out.print("\t");
        for (String word : setToShow)
        {
            System.out.print(word + " ");
        }
        System.out.println();
    }

}
