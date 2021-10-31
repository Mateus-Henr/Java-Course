package tutorial.first;

public class Main
{
    public static void main(String[] args)
    {
        // Methods == Behaviour | Data members == State
        // Classes are blueprint to create objects.
        Car porsche; // Defining an object
        porsche = new Car(); // Instantiating an object
        Car holden = new Car();

        porsche.model = "Carrera"; // Not recommended
    }
}
