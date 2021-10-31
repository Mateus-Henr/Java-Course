package challenge;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody
{
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    protected HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType)
    {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public boolean addSatellite(HeavenlyBody satellite)
    {
        return this.satellites.add(satellite);
    }

    public static Key makeKey(String name, BodyTypes bodyType) // Can be used without instantiation
    {
        return new Key(name, bodyType);
    }

    public Key getKey()
    {
        return this.key;
    }

    public double getOrbitalPeriod()
    {
        return this.orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites()
    {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        Key objKey = ((HeavenlyBody) obj).getKey();
        return this.key.equals(objKey);
    }

    @Override
    public final int hashCode() // This method is called whenever there's operations with HashSet
    {
        return this.key.hashCode();
    }

    @Override
    public String toString()
    {
        return this.key.toString() + ", " + this.orbitalPeriod;
    }

    public enum BodyTypes
    {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public static final class Key
    {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType)
        {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName()
        {
            return this.name;
        }

        public BodyTypes getBodyType()
        {
            return this.bodyType;
        }

        @Override
        public boolean equals(Object obj)
        {
            Key objKey = (Key) obj;
            return (objKey.name.equals(this.name) && objKey.bodyType.equals(this.bodyType));
        }

        @Override
        public int hashCode()
        {
            return (this.name.hashCode() + this.bodyType.hashCode() + 57);
        }

        @Override
        public String toString()
        {
            return this.name + ": " + this.bodyType;
        }

    }

}

