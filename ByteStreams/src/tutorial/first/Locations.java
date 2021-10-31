package tutorial.first;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location>
{
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException
    {
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")));)
        {
            // These data could be written in a log file.
            for (Location location : locations.values())
            {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription()); // String
                System.out.println("Writing location " + location.getLocationID() + " - " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet())
                {
                    if (!direction.equalsIgnoreCase("Q"))
                    {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    // New code to read from the ".dat" file. Something that's worthy remembering is that the data contained in
    // the file needs to be processed before being read.
    static
    {
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat"))))
        {
            boolean eof = false;
            // When using while true, we are using the exception that is thrown when there's no more data
            // to read to quit the loop. But if we do this, we couldn't differentiate if the exception
            // happened because of the end of the program or because of other reason.
            // In order to fix it, the "eof" code has been added.
            while (!eof)
            {
                try
                {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0; i < numExits; i++)
                    {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + ", " + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));
                }
                catch (EOFException e) // Will catch just the EOF Exception.
                {
                    eof = true;
                }
            }
        }
        catch (IOException e) // Will catch other exceptions.
        {
            System.out.println("IO Exception.");
        }
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
