package tutorial.challenge;

public class TV
{
    private Resolution resolution;
    private String model;

    public TV(Resolution resolution, String model)
    {
        this.resolution = resolution;
        this.model = model;
    }

    public Resolution getResolution()
    {
        return resolution;
    }

    public String getModel()
    {
        return model;
    }

}
