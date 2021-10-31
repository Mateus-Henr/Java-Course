package tutorial.first;


// We use abstract class to define behaviours that are necessary without saying what that's going to perform.
// When using the "abstract" keyword in methods it says that those methods need to be implemented.
// Not all methods need to be "abstract", for example here we've got "getName()" that's not abstract, so this method
// has its own implementation here and this is going to be used if you want to se the name.
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

}
