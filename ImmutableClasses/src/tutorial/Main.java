package tutorial;

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

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest.", tempExit));

        storedDirections.put("QUIT", "Q");
        storedDirections.put("WEST", "W");
        storedDirections.put("EAST", "E");
        storedDirections.put("NORTH", "N");
        storedDirections.put("SOUTH", "S");


        int loc = 1;
        while (true)
        {
            System.out.println(locations.get(loc).getDescription());
            // tempExit is holding a map of exits for each location
            // When ypu delete a location it's going to get the last reference of the map.
            // Therefore as forest is the last "new map" if you delete south you'll be deleting the location present there.
            // To avoid it we are creating a new map from the current locations when creating the location object.
            tempExit.remove("S");
            // Even if we are passing the map as argument before, it doesn't mean that the alterations afterwards won't change
            // it. Remember when using object, what's saved in memory is a reference to that object. Therefore by editing
            // the map here will edit the reference that is the reference used by the Location class. So any changes on the
            // map will be seen by location as well.

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
                String[] typedWords = direction.split(" ");

                for (String isolatedWord : typedWords)
                {
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
