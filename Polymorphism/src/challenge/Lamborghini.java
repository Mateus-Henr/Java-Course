package challenge;

public class Lamborghini extends Car
{
    private String brand;
    private boolean isEngineOn;
    private boolean isMoving;

    public Lamborghini(String name, int cylinders)
    {
        super(name, cylinders);
        this.brand = "Lamborghini";
        this.isEngineOn = false;
        this.isMoving = false;
    }

    @Override
    public void startEngine()
    {
        if (!isEngineOn)
        {
            System.out.println("The engine of your " + brand + " " + getName() + " is being started. Vruum... Vruum..");
            isEngineOn = true;
        } else
            System.out.println(brand + " " + getName() + " says => I am already on!");
    }

    @Override
    public void accelerate()
    {
        if (isEngineOn)
        {
            System.out.println("Your " + brand + " " + getName() + " is going faster! Hold tight!");
            isMoving = true;
        } else
            System.out.println(brand + " " + getName() + " says => ....... Haven't.... you realized that I am off???");
    }

    @Override
    public void brake()
    {
        if (isEngineOn)
            if (isMoving)
                System.out.println(brand + " " + getName() + " says => It seems that someone wants to stop me... I will agree with you for now.");
            else
                System.out.println(brand + " " + getName() + " says => I'm already stationary how do you suppose that I do something? ");
        else
            System.out.println(brand + " " + getName() + " says => ....... Haven't.... you realized that I am off???");

    }

}
