package tutorial.challenge;

public class Wardrobe
{
    private String material;
    private int numberOfDoors;
    private int numberOfDrawers;
    private Size size;

    public Wardrobe(String material, int numberOfDoors, int numberOfDrawers, Size size)
    {
        this.material = material;
        this.numberOfDoors = numberOfDoors;
        this.numberOfDrawers = numberOfDrawers;
        this.size = size;
    }

    public String getMaterial()
    {
        return material;
    }

    public int getNumberOfDoors()
    {
        return numberOfDoors;
    }

    public int getNumberOfDrawers()
    {
        return numberOfDrawers;
    }

    public Size getSize()
    {
        return size;
    }

}
