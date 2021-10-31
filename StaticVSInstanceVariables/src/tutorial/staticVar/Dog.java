package tutorial.staticVar;

// Static Variables Example
// Static variables are shared between instances, in other words, if we change a static variable all objects that
// are using that static variable will be affected.
public class Dog
{
    private static String name;

    public Dog(String name)
    {
        Dog.name = name;
    }

    public void printName()
    {
        System.out.println("Name = " + name);
    }
}

class Main2
{
    public static void main(String[] args)
    {
        Dog rex = new Dog("rex"); // Creates instance (rex)
        Dog fluffy = new Dog("fluffy"); // Creates instance (fluffy)
        rex.printName(); // prints fluffy
        fluffy.printName(); // prints fluffy
    }
}
