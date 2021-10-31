package tutorial.second;

public abstract class Animal
{
    private String name;

    public Animal(String name)
    {
        this.name = name;
    }

    public abstract void eat();

    public abstract void breathe();

    public String getName()
    {
        return name;
    }

    // You could think that the methods eat and breathe should be implemented by an interface, but as all animals
    // perform those action, they are better to be in the base class as it's now.
    // In interfaces you require static variables since non-static variables require to be instantiate and as interfaces
    // are abstract you cannot do that.
}
