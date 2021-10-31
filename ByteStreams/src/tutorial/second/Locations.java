package tutorial.second;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location>
{
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    // Representation of a file in bytes
    // Start at byte 0
    // We can read until we reach the EOF (EndOfFile). Or until it finishes writing the data.
    // We've got to follow a pattern when dealing with bytes.
    // In the case of this project, if a player moves to a new location, the file should be read at the point where
    // the new location is at in the file.

    // File pointer is an offset in the file where the read or write will start from.
    // Offset is a byte location in the file. If the file pointer is set to 100, it means that the operation
    // will start at 100. (As an int is four bytes and it starts in 100, it will be found in 100 to 103)
    // And as always is 0 based, so the first byte is at position 0.
    // After that the file pointer will be advanced based on the number of bytes that we read or wrote.
    // Ex: File pointer == 100 and we read/write five bytes, its new position will be 105.
    // The offset is where the value's first byte is located.

    // When using "Random Access Files" we refer to each set of related data as as record. In the context of our
    // app the fields of a location object make up the record for a location.

    // The formula if locations occupy the same size in a file of 30 bytes: startByte = (n - 1) * 30
    // But as our locations don't have the same length, we will have to include an "index", that will store
    // the offset, record length of each location and locationID.
    // Applied to this program it would be:
    // Firstly we would get the index record for the location.
    // Secondly we would use the index number to read the location data.
    // All index have to have the same length (if not we would have to have an index for the index)
    // In our context described above (the offset, record length of each location and locationID) would be 12 bytes.
    // As all index will have 12 bytes so the location record will always be longer.
    // We could access the index record from the file or load it into memory.
    // Loading all the index into memory is faster than reading each index from a file.
    // Keep in mind that the index must be smaller than the record. (Because the index would take more space on memory
    // than the record itself).

    // Saving indexes onto the file
    // When writing indexes on the file, before the data, the record isn't going to start at byte 0 anymore.
    // We have to safe the offset of the data section to the file (Usually saved at the top of the file)

    // In the context of our application
    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the location section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte
    // 8 and end at byte 1699)
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700.

    // To jump to a different offset in the file we can use the "seek()" method.
    // Or we could read data sequentially, example if the data we are going to read is after the last record that
    // we read, the file pointer will be at the right position already.

    // INCREDIBLY IMPORTANT INFORMATION ABOUT THE IMPLEMENTATION ABOVE AT THE END OF THIS FILE.

    public static void main(String[] args) throws IOException
    {
        // Using ObjectOutputStream now
        // A file contained a Serializable object is meant to be read by Java.
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")));)
        {
            for (Location location : locations.values())
            {
                // The object location and all of its fields are Serializable, so we can just call the method below.
                locFile.writeObject(location);
            }
        }
    }

    static
    {
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat"))))
        {
            boolean eof = false;
            while (!eof)
            {
                try
                {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " - " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits.");

                    locations.put(location.getLocationID(), location);
                }
                catch (EOFException e)
                {
                    eof = true;
                }
            }

        }
        // This exception is thrown because the serialVersionUID no longer match.
        catch (InvalidClassException e)
        {
            System.out.println("InvalidClassException " + e.getMessage());
        }
        catch (IOException io)
        {
            System.out.println("IO Exception " + io.getMessage());
        }
        // This exception will be thrown if the class which the serializable data is from is not found.
        // For example if another application try to get the data, but it doesn't have the Location class.
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException " + e.getMessage());
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

// The file that we are going to use RandomAccessFile class (or "raf") will be export the Locations class in to dat
// file called "location_rand.dat". This file will consist of 2 parts. Header and Data
//
// 1. The header file structure. The header file structure contain 2 parts. Fixed header -- 8 bytes
// and variable header 12 bytes * numbers of location.
//
// 1.1 The number of location in this .dat file e.g. 141 locations. -- this take 4 bytes -- bytes 00 - 03
// 1.2 The offset that data file will start. This is also a single number -- this take 4 bytes -- bytes 04-07
//
// 1.3 The variable part. this is 12 bytes which consist of:
//
// a) Location_ID -- 4 bytes (e.g. 1 - 141)
//
// b) Offset the locations stored in this file - 4 bytes. (e.g. location0 store at offset#1700)
//
// c) The size of this location. Since each location contain String which can be vary by each location.
// This field take 4 bytes.
//
// (This section is 12 bytes in Java which is the sum of a + b + c)
//
// Therefore, if we have 141 locations then the actual location data will start at 8 + (12 x 141) = offset#1700