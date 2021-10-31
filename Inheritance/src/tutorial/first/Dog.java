package tutorial.first;

// When extending we could consider the "super" as a way to initialize the basic
// characteristics of an animal and from this, we can pass specific characteristics of a Dog (state and behaviour)
// Also as we are extending from the base class, we also have access to the methods and variables from there.
public class Dog extends Animal
{
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat)
    {
        super(name, 1, 1, size, weight); // We use "super" to call the constructor for the super class. Therefore the constructor in the super class is required.
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew()
    {
        System.out.println("Dog.chew() called.");
    }

    @Override
    public void eat()
    {
        System.out.println("Dog.eat() called.");
        chew();
        super.eat();
    }

    @Override
    public void move()
    {
        super.move();
    }

}
