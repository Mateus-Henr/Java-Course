package tutorial.first;

// The other methods are already overridden in the Bird class, so we don't need to override them directly.
public class Parrot extends Bird
{
    public Parrot(String name)
    {
        super(name);
    }

    @Override
    public void fly()
    {
        System.out.println("Flitting from branch to branch");
    }

}
