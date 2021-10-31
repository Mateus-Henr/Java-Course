package challenge.mine.second;

public class Gallery extends HardDisk
{
    private String name;
    private String photo;

    public Gallery(String photo)
    {
        this.name = "" + Math.random();
        this.photo = photo;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    @Override
    public String toString()
    {
        return "Gallery { " +
                "Photo name='" + name + '\'' +
                ", Photo content='" + photo + '\'' +
                '}';
    }

}
