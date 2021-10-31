package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
        dog.eat(); // When inheriting you can use methods from the base class in the sub classes,
        // but if the subclass is overriding a method from the base class the method used is gonna be the overridden one,
        // otherwise it's gonna be method from the base class.
    }

}
