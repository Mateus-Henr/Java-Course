package challenge.mine;

public class Car extends Vehicle
{
    private final boolean isHandSteering;
    private int currentGear;

    public Car(boolean isHandSteering)
    {
        super("4-door car");
        this.isHandSteering = isHandSteering;
        this.currentGear = 0;
    }

    public void changeGears(int gearToChangeTo)
    {
        if (this.currentGear == gearToChangeTo)
        {
            System.out.println("Already at the gear " + gearToChangeTo);
        }
        else if (gearToChangeTo < 0 || gearToChangeTo > 8)
        {
            System.out.println("Invalid gear has been provided.");
        }
        else
        {
            this.currentGear = gearToChangeTo;
            System.out.println("The gear has been changed to " + gearToChangeTo);
        }
    }

    public boolean isHandSteering()
    {
        return isHandSteering;
    }

    public int getCurrentGear()
    {
        return currentGear;
    }

}
