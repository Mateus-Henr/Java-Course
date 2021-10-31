package tutorial.second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Serialization is the process of translating a data structure or object into a format that can store or recreated.
// We need to implement the "Serializable" class.
// When making a class "Serializable" you need to create a long field called "serialVersionUID".
// This filed is some sort of version number for a class.
public class Main
{
    private static Locations locations = new Locations();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        int loc = 64;
        while (true)
        {
            System.out.println(locations.get(loc).getDescription());

            if (loc == 0)
            {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet())
            {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1)
            {
                String[] words = direction.split(" ");
                for (String word : words)
                {
                    if (vocabulary.containsKey(word))
                    {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction))
            {
                loc = exits.get(direction);

            }
            else
            {
                System.out.println("You cannot go in that direction");
            }
        }

    }

}
