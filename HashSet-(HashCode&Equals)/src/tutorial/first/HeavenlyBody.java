package tutorial.first;

import java.util.HashSet;
import java.util.Set;

// As the HeavenlyBody is defined as a final class, it cannot be subclassed.
// Because of that the "equals" method wouldn't return true if the compared class were a subclass of this class.
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

    @Override // By using @Override, the compiler makes sure that you're using the right signature for the method.
    public boolean equals(Object obj)
    {
        if (this == obj) // Compares if the object is being compared to itself. Like: earth.equals(earth); and will point to the same point in memory since it's one object.
        {
            return true;
        }
        System.out.println("obj.get() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        if ((obj == null) || (obj.getClass() != this.getClass())) // In order to make subclasses do not compare equals, we are getting the class itself and comparing them.
        { // If we try a getClass with a null object, an null exception is gonna be thrown, that's why there's the checking there and by using || when it finds a true
            // condition it returns.
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName); // Comparing just the names using the equals from String class.
    } // It's not valid if there's no hashcode.

    @Override
    public int hashCode()
    {
        System.out.println("hashCode called.");
        return this.name.hashCode() + 57;
    }

}
