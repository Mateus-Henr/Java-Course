package challenge;


// Using getClass().getSimpleName() you can get the name of the class so you don't need to bother in the future

// First Way of defining a class (Class in the same file)
class Porsche extends Car
{
    private boolean isEngineOn;
    private boolean isMoving;

    public Porsche(String name, int cylinders)
    {
        super(name, cylinders);
        this.isEngineOn = false;
        this.isMoving = false;
    }

    @Override
    public void startEngine()
    {
        if (!isEngineOn)
        {
            System.out.println("The engine of your " + getClass().getSimpleName() + " " + getName() + " is being started. Vruum... Vruum..");
            isEngineOn = true;
        } else
            System.out.println(getClass().getSimpleName() + " " + getName() + " says => I am already on!");
    }

    @Override
    public void accelerate()
    {
        if (isEngineOn)
        {
            System.out.println("Your " + getClass().getSimpleName() + " " + getName() + " is going faster! Hold tight!");
            isMoving = true;
        } else
            System.out.println(getClass().getSimpleName() + " " + getName() + " says => ....... Haven't.... you realized that I am off???");
    }

    @Override
    public void brake()
    {
        if (isEngineOn)
            if (isMoving)
                System.out.println(getClass().getSimpleName() + " " + getName() + " says => It seems that someone wants to stop me... I will agree with you for now.");
            else
                System.out.println(getClass().getSimpleName() + " " + getName() + " says => I'm already stationary how do you suppose that I do something? ");
        else
            System.out.println(getClass().getSimpleName() + " " + getName() + " says => ....... Haven't.... you realized that I am off???");

    }

}

public class Main
{
    public static void main(String[] args)
    {
        // Uses the first way of defining a class
        Car porsche = new Porsche("Panamera", 4);
        porsche.startEngine();
        porsche.accelerate();
        porsche.brake();

        System.out.println("\n\n\n");

        // Second way of defining a class (Used more in event listeners)
        Car ferrari = new Car("488", 10)
        {
            private String brand = "Ferrari";
            private boolean isEngineOn = false;
            private boolean isMoving = false;

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
        };
        ferrari.startEngine();
        ferrari.brake();
        ferrari.accelerate();

        System.out.println("\n\n\n");

        // Third Way of defining a class (Class in different file) (The better usually)
        Car lamborghini = new Lamborghini("Aventador", 20);
        lamborghini.brake();
        lamborghini.startEngine();
        lamborghini.accelerate();

        System.out.println("\n\n\n");

        // Uses the fourth way of defining a class
        Car unknown = new Unknown("IDK", 6);
        unknown.brake();
        unknown.startEngine();
        unknown.accelerate();
    }

    // Fourth way of defining a class (Inner Class)
    static class Unknown extends Car
    {
        private String brand;
        private String name;

        public Unknown(String name, int cylinders)
        {
            super(name, cylinders);
            this.brand = "Unknown";
            this.name = name;
        }

    }

}
