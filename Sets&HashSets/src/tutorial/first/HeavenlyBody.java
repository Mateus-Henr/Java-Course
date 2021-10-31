package tutorial.first;

import java.util.HashSet;
import java.util.Set;

// We use final in objects in order to not allow modifications on the object's reference.
// So we cannot point to another object if final is being used.
// But the object is still free to modifications so a List for example can be altered even if you're using the final
// keyword
public class HeavenlyBody
{
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod)
    {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName()
    {
        return this.name;
    }

    public double getOrbitalPeriod()
    {
        return this.orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon)
    {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites()
    {
        return new HashSet<>(this.satellites);
    }

}
