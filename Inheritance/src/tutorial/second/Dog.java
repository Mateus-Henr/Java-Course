package tutorial.second;

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
        super(name, 1, 1, size, weight);
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

    public void walk()
    {
        System.out.println("Dog.walk() called.");
        move(5); // It's better to use "move()" instead of "super.move()", because if in the future we override the move method the correct method will be called.
    }

    public void run()
    {
        System.out.println("Dog.run() called.");
        move(10);
    }

    private void moveLegs(int speed)
    {
        System.out.println("Dog.moveLegs() called.");
    }

    @Override
    public void move(int speed)
    {
        System.out.println("Dog.move() called.");
        moveLegs(speed);
        super.move(speed);
    }

}
