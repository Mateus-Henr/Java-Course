package challenge.tutorial.second;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable
{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength)
    {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHitPoints()
    {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }

    public int getStrength()
    {
        return strength;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    @Override
    public List<String> write()
    {
        List<String> values = new ArrayList<>();

        values.add(this.name);
        values.add("" + this.hitPoints);
        values.add("" + this.strength);

        return values;
    }

    @Override
    public void read(List<String> savedValues)
    {
        if (savedValues != null)
        {
            if (!savedValues.isEmpty())
            {
                this.name = savedValues.get(0);
                this.hitPoints = Integer.parseInt(savedValues.get(1));
                this.strength = Integer.parseInt(savedValues.get(2));
            }
        }
    }

    @Override
    public String toString()
    {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength + '\'' +
                '}';
    }

}
