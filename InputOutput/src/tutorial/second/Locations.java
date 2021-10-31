package tutorial.second;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location>
{
    private static Map<Integer, Location> locations = new HashMap<>();

    // In the concept of this program if an exception happens here, it means that the values couldn't be loaded
    // therefore it would make more sense to throw the exception back up.
    public static void main(String[] args) throws IOException // Specifying that the main method throws this exception.
    {
        // We defined it here, because try/catch/finally blocks introduce a new scope.
        FileWriter locFile = null;

        // There are two categories of exceptions in Java, the checked and the unchecked.
        // The difference is that you can't ignore checked exceptions, such as the one that would happen bellow
        // if we weren't using the try/catch block.

        try
        {
            locFile = new FileWriter("locations.txt"); // File name in the constructor

            // If you want to throw an exception:
            // It fails so the object because it could access the file.
            // As it crashes it doesn't attempt to use the "write" method.
//            locFile = new FileWriter("location.txt");

            for (Location location : locations.values())
            {
                // Writing data to a file.
                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//                throw new IOException("Test exception thrown while writing.");
            }
            // A problem would be if an exception happens in the for loop the FileWriter wouldn't be closed.
//            locFile.close(); // Can cause problems if not used such as data corruption.
        }
//        catch (IOException e) // Commented because we've started to throw the exception.
//        {
//            System.out.println("In catch block.");
//            e.printStackTrace();
//        }
        finally
        {
            System.out.println("In finally block.");
//            try
//            {
            // Checking if it's null to avoid exception.
            if (locFile != null) // Defensive programming
            {
                System.out.println("Attempting to close locfile.");
                locFile.close();
            }
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
        }
    }

    static
    {
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));
    }

    @Override
    public int size()
    {
        return locations.size();
    }

    @Override
    public boolean isEmpty()
    {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key)
    {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key)
    {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value)
    {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key)
    {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m)
    {

    }

    @Override
    public void clear()
    {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet()
    {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values()
    {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet()
    {
        return locations.entrySet();
    }

}
