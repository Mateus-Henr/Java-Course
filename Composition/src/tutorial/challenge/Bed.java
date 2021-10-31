package tutorial.challenge;

public class Bed
{
    private String material;
    private String type;

    public Bed(String material, String type)
    {
        this.material = material;
        this.type = type;
    }

    public void makeTheBed() {
        System.out.println("Make the bed!");
    }

    public String getMaterial()
    {
        return material;
    }

    public String getType()
    {
        return type;
    }

}
