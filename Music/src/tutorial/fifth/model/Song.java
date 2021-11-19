package tutorial.fifth.model;

public class Song
{
    private int ID;
    private int track;
    private String name;
    private int albumID;

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getTrack()
    {
        return track;
    }

    public void setTrack(int track)
    {
        this.track = track;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAlbumID()
    {
        return albumID;
    }

    public void setAlbumID(int albumID)
    {
        this.albumID = albumID;
    }

}
