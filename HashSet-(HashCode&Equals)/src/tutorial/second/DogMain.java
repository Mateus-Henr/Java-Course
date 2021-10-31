package tutorial.second;

public class DogMain
{
    public static void main(String[] args)
    {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)); // true
        System.out.println(rover.equals(rover2)); // false
    }

    // A Labrador is an instance of Dog, but Dog is not an instance of Labrador.

    // The above comparison can be fixed by removing the "equals" method from the "Labrador" class,
    // once it tries to cast the "Dog" to a "Labrador" which is not the case.
}
