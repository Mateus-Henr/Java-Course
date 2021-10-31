package tutorial;

import java.util.HashMap;
import java.util.Map;

// Example of immutable class
// Immutable class means a class in which when an instance is created I can't be changed.
public final class Location
{
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits)
    {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>(exits); // By creating this we can disassociate the coming map with the internal value, making this even better.
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location)
//    {
//        this.exits.put(direction, location);
//    }

    public int getLocationID()
    {
        return locationID;
    }

    public String getDescription()
    {
        return description;
    }

    public Map<String, Integer> getExits()
    {
        // Getter returns a copy of the exits, so the exits themselves cannot be altered.
        return new HashMap<String, Integer>(exits);
    }

}
// Immutable class characteristics
// 1 - Don't provide setters.
// 2 - make all fields private and final.
// 3 - Don't allow subclasses to override methods (Since we would be changing the method). To avoid it you can define the class as final.
// 4 - Don't allow the objects to be changed after the instance creation.