package tutorial.second;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location implements Serializable // If we want an object to be serializable all of its filed will be as well.
{
    private long serialVersionUID = 1L;
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits)
    {
        this.locationID = locationID;
        this.description = description;
        if (exits != null)
        {
            this.exits = new LinkedHashMap<>(exits);
        }
        else
        {
            this.exits = new LinkedHashMap<>();
        }
        this.exits.put("Q", 0);
    }

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
        return new LinkedHashMap<>(exits);
    }

    protected void addExit(String direction, int destination)
    {
        exits.put(direction, destination);
    }

}

// The serialization runtime associates with each serializable class a version number, called a serialVersionUID,
// which is used during deserialization to verify that the sender and receiver of a serialized object have loaded
// classes for that object that are compatible with respect to serialization. If the receiver has loaded a class for
// the object that has a different serialVersionUID than that of the corresponding sender's class, then deserialization
// will result in an InvalidClassException. This occurs when we don't define a "serialVersionUID", since it doesn't
// match the previous value defined (in this case 1L).