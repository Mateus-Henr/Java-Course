package challenge;

public class Car
{
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private boolean isEngineOn;
    private boolean isMoving;

    public Car(String name, int cylinders)
    {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
        this.isEngineOn = false;
        this.isMoving = false;
    }

    public String getName()
    {
        return name;
    }

    public void startEngine()
    {
        if (!isEngineOn)
        {
            System.out.println("The engine is being started. Vruum... Vruum..");
            isEngineOn = true;
        } else
            System.out.println("I'm already on!");
    }

    public void accelerate()
    {
        if (isEngineOn)
        {
            System.out.println("Going faster! Hold tight!");
            isMoving = true;
        } else
            System.out.println("....... Haven't.... you realized that I'm off???");
    }

    public void brake()
    {
        if (isEngineOn)
        {
            if (isMoving)
                System.out.println("It seems that someone wants to stop me...");
            else
                System.out.println("I'm already stationary how do you suppose that I do something? ");
        } else
            System.out.println("....... Haven't.... you realized that I'm off???");
    }

}
