package tutorial;

public class SharedResource
{
    private Worker owner;

    public SharedResource(Worker owner)
    {
        this.owner = owner;
    }

    public Worker getOwner()
    {
        return owner;
    }

    // Changing data. Avoid thread interference when accessing the resource.
    public synchronized void setOwner(Worker owner)
    {
        this.owner = owner;
    }


}
