package tutorial.second;

public class Penguin extends Bird
{
    public Penguin(String name)
    {
        super(name);
    }

    @Override
    public void fly() // Makes sense to have this overridden method here since we want to give an specific behaviour to
    {                 // a penguin that's different from the majority.
        super.fly();
        System.out.println("I'm not very good at that, can I go for a swim instead.");
    }

}
