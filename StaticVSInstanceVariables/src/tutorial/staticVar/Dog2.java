package tutorial.staticVar;

// Instance Variables Example
public class Dog2
{
    private String name;

    public Dog2(String name)
    {
        this.name = name;
    }

    public void printName()
    {
        System.out.println("Name = " + name);
    }
}

class Main3
{
    public static void main(String[] args)
    {
        Dog2 rex = new Dog2("rex"); // Creates instance (rex)
        Dog2 fluffy = new Dog2("fluffy"); // Creates instance (fluffy)
        rex.printName(); // prints rex
        fluffy.printName(); // prints fluffy
    }
}
