package tutorial.instanceMeth;

// Instance Methods Example
public class Dog
{
    public void bark()
    {
        System.out.println("woof");
    }
}

class Main3
{
    public static void main(String[] args)
    {
        Dog rex = new Dog(); // Create instance
        rex.bark(); // Call instance method
    }
}
