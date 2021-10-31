package tutorial.first;

// Here an abstract class is extending another abstract class, in other words, we are narrowing down an animal +
// using the common behaviours of an Animal (base class).
public abstract class Bird extends Animal
{
    public Bird(String name)
    {
        super(name);
    }

    @Override
    public void eat()
    {
        System.out.println(getName() + " is pecking.");
    }

    @Override
    public void breathe()
    {
        System.out.println("Breathe in, breathe out, repeat...");
    }

    public abstract void fly();

}
