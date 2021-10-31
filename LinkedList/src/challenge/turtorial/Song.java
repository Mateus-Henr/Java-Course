package challenge.turtorial;

public class Song
{
    private String title;
    private double duration;

    public Song(String title, double duration)
    {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle()
    {
        return this.title;
    }

    public double getDuration()
    {
        return this.duration;
    }

    @Override
    public String toString()
    {
        return "\"" + this.title + ": " + this.duration + "min\"";
    }

}
