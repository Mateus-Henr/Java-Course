package tutorial.challenge;

public class Table
{
    private int width;
    private int length;
    private int height;
    private int numberOfDrawers;
    private String color;
    private String material;

    public Table(int width, int length, int height, int numberOfDrawers, String color, String material)
    {
        this.width = width;
        this.length = length;
        this.height = height;
        this.numberOfDrawers = numberOfDrawers;
        this.color = color;
        this.material = material;
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

    public int getHeight()
    {
        return height;
    }

    public int getNumberOfDrawers()
    {
        return numberOfDrawers;
    }

    public String getColor()
    {
        return color;
    }

    public String getMaterial()
    {
        return material;
    }

}
