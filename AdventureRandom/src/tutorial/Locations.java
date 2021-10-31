package tutorial;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
// WE ARE LOADING DATA ON DEMAND HERE
public class Locations implements Map<Integer, Location>
{
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException
    {
        // The "rwd" indicates that we want to open the file for reading and writing and that we want writing to occur
        // synchronously. It deals with synchronization.
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd"))
        {
            // We will be loading locations on demand when we run the game. The locations data file will remain open
            // while the application runs.
            rao.writeInt(locations.size()); // First step writing the numbers of locations to the file.
            // The start-offset of the locations section.
            // Using 3 because is the number of ints contained in each record. Locations.size() is
            // used to get the quantity of IDs.
            // Each index record will contain three integers, the location ID, the offset for the location and the
            // length of the location. (THESE ARE USED TO DETERMINE THE SIZE OF THE INDEX)
            int indexSize = locations.size() * 3 * Integer.BYTES;

            // Here we are calculating the current position of the file pointer to the index size to account for the
            // value that we've already written to the file. Beyond that, we are accounting for the integer that
            // we are about to write to the file that is the location offset calculated before.
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES); // Offset for the location section.
            rao.writeInt(locationStart);

            // The next section in the file
            // Before the index we are writing the locations because each index record requires the offset for the
            // location. And we don't know the index until we've written the location.
            // In order to not jump around in the file, we will write all the location and after that write the index
            // as a whole. Disk access is expensive (even more expensive when it's not sequential).
            long indexStart = rao.getFilePointer(); // Saving the current position of the file pointer.

            // This variable will update after writing each location.
            // The location ID will work as a map key to locate the locations record in memory.

            int startPointer = locationStart; // Calculate location's length to get the right position.
            // Moving the pointer to the first location offset.
            // We only need to do this fir the first location because we are writing data sequentially.
            rao.seek(startPointer);

            // When using "RandomAccessFiles" we can't read/write objects and it can't be chained to other types of
            // IO classes.
            for (Location location : locations.values())
            {
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();

                for (String direction : location.getExits().keySet())
                {
                    if (!direction.equalsIgnoreCase("Q"))
                    {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                        // direction, locationID, direction, locationID
                        // N,1,U,2
                    }
                }

                rao.writeUTF(builder.toString());

                // Second parameter is the record length.
                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer(); // Updating the file pointer for the next location.
            }

            rao.seek(indexStart);
            for (Integer locationID : index.keySet())
            {
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }
        }
    }

    static
    {
        // We won't be loading locations on the memory anymore, we will be loading them on demand.
        try
        {
            ra = new RandomAccessFile("locations_rand.dat", "rwd"); // Open the file
            int numLocations = ra.readInt(); // Good practise
            long locationStartPoint = ra.readInt(); // Offset of the location section

            while (ra.getFilePointer() < locationStartPoint)
            {
                // Reading the index and creating the records
                int locationID = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationID, record);
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException in static initializer: " + e.getMessage());
        }
    }

    public void close() throws IOException // When the player closes the game
    {
        ra.close();
    }

    // This method will be used everytime the player moves to a new location.
    public Location getLocation(int locationID) throws IOException
    {
        IndexRecord record = index.get(locationID);
        ra.seek(record.getStartByte());
        int id = ra.readInt(); // Good Practise
        String description = ra.readUTF(); // This method reads the length of the string then it reads its bytes.
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        // Using null because we don't have the exits yet.
        Location location = new Location(locationID, description, null);

        if (locationID != 0)
        {
            for (int i = 0; i < exitPart.length; i++)
            {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
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