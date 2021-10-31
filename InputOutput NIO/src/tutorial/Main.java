package tutorial;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  java.nio is described as an improvement to Java I/O because the classes in the package perform I/O in
//  a non-blocking manner.
//  They've got resources to deal with file system and resources to deal with reading/writing data.
//  When using classes in the java.io package, a thread will block while it's waiting to read or write the stream
//  buffer, which is the opposite of the java.nio package.
//  When using java.nio we deal with data in clocks (channels and buffers).
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
//        int loc = 1;
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
