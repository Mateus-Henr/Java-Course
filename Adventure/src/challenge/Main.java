package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<String, String> storedDirections = new HashMap<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java."));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building."));
        locations.put(2, new Location(2, "You are at the top of a hill."));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring."));
        locations.put(4, new Location(4, "You are in a valley beside a stream."));
        locations.put(5, new Location(5, "You are in the forest."));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        storedDirections.put("QUIT", "Q");
        storedDirections.put("WEST", "W");
        storedDirections.put("EAST", "E");
        storedDirections.put("NORTH", "N");
        storedDirections.put("SOUTH", "S");


        int loc = 1;
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

            if (direction.length() > 1) // Checks if the string has more than one character.
            {
                String[] typedWords = direction.split(" ");

                for (String isolatedWord : typedWords)
                {
//                    for (String directionToCheck : directions.keySet()) // Don't actually need to loop, I can use contains().
//                    { // Was being used to allow the usage of "equalsIgnoreCase()"
//                        if (directionToCheck.equalsIgnoreCase(word))
//                        {
//                            direction = directions.get(directionToCheck);
//                            break;
//                            // I could also have used an array list. If so, I would just need to get the first char of the word.
//                        }
//                    }
                    if (storedDirections.containsKey(isolatedWord))
                    {
                        direction = storedDirections.get(isolatedWord);
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
                System.out.println("You cannot go in that direction.");
            }
        }

    }

}
